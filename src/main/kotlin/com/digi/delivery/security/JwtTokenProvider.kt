package com.digi.delivery.security

import com.digi.delivery.component.JwtConfig
import com.digi.delivery.constant.MessageKey
import com.digi.delivery.repository.AccessTokenRepository
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.security.Key
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

@Component
@Slf4j
class JwtTokenProvider(
    private val jwtConfig: JwtConfig,
    @Autowired private val accessTokenRepository: AccessTokenRepository,
) {
    private val log = LoggerFactory.getLogger(JwtTokenProvider::class.java)
    private lateinit var secretKey: String


    private val AUTHORITIES_KEY = "auth"

    private val SCOPES = "scopes"
    private val REFRESH_TOKEN = "REFRESH_TOKEN"
    private lateinit var key: Key

    private val tokenCache = mutableMapOf<Long, String>()

    @PostConstruct
    private fun init() {
        secretKey = Base64.getEncoder().encodeToString(jwtConfig.secret.toByteArray())
        val keyBytes: ByteArray = Decoders.BASE64.decode(secretKey)

        key = Keys.hmacShaKeyFor(keyBytes)
    }

    /**
     * Create JWT token based on the given authenticated information.
     */
    fun createToken(authentication: Authentication): String {
        val authorities = authentication.authorities.joinToString(",") { it.authority }

        return Jwts.builder()
            .setSubject(authentication.name)
            .claim(AUTHORITIES_KEY, authorities)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(
                Date.from(
                    Instant.now().plus(jwtConfig.accessTokenExpirationInMilliseconds ?: 0, ChronoUnit.MILLIS)
                )
            )
            .compact()
    }

    /**
     * Create refresh token based on authenticated information.
     */
    fun createRefreshToken(authentication: Authentication): String {
        if (authentication.name.isEmpty()) {
            throw IllegalArgumentException(MessageKey.BAD_CREDENTIAL)
        }

        val authorities = authentication.authorities.joinToString(",") { it.authority }

        val claims = Jwts.claims().setSubject(authentication.name)
        claims.put(SCOPES, listOf(REFRESH_TOKEN))
        claims.put(AUTHORITIES_KEY, authorities)

        return Jwts.builder()
            .setClaims(claims)
            .setId(UUID.randomUUID().toString())
            .setExpiration(
                Date.from(
                    Instant.now().plus(jwtConfig.refreshTokenExpirationInMilliseconds ?: 0, ChronoUnit.MILLIS)
                )
            )
            .signWith(key, SignatureAlgorithm.HS512)
            .compact()
    }


    fun resolveToken(request: HttpServletRequest): String? {
        val header = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION)

        return if (StringUtils.hasText(header) && header.contains(jwtConfig.authPrefix)) {
            header.substring(7)
        } else {
            null
        }
    }

    fun validateToken(token: String, isRefreshToken: Boolean? = false): Boolean {
        return try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            if (isRefreshToken != null && isRefreshToken) {
                return true
            }
            return tokenCache.containsValue(token)
        } catch (e: IllegalArgumentException) {
            log.debug("validateToken >> Authorization Token is Expired or Invalid JWT")
            false
        } catch (e: ExpiredJwtException) {
            log.info("Expired JWT token.")
            log.trace("Expired JWT token trace: {}", e)
            false
        } catch (e: UnsupportedJwtException) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e)
            false
        } catch (e: JwtException) {
            log.debug("validateToken >> Authorization Token is Expired or Invalid JWT")
            false
        }
    }

    fun validateTokenDB(token: String?): Boolean {
        return try {
            if (token.isNullOrEmpty()) false
            else this.validateToken(token) && accessTokenRepository.existsByToken(token)
        } catch (e: JwtException) {
            log.debug("Authorization Token is Expired or Invalid JWT")
            false
        } catch (e: IllegalArgumentException) {
            log.debug("Authorization Token is Expired or Invalid JWT")
            false
        }
    }

    fun getAuthentication(token: String): Authentication {
        val claims = Jwts.parser().setSigningKey(key)
            .parseClaimsJws(token)
            .body
        val authorities = claims[AUTHORITIES_KEY].toString().split(",").map { SimpleGrantedAuthority(it) }.toList()

        val user = User(claims.subject, "", authorities)
        return UsernamePasswordAuthenticationToken(user, token, authorities)
    }

    fun addToken(userId: Long, accessToken: String) {
        tokenCache[userId] = accessToken
    }

    fun revokeToken(userId: Long) = tokenCache.remove(userId)

}