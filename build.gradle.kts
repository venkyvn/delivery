import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"

    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("plugin.allopen") version "1.9.24"
}

java.sourceCompatibility = JavaVersion.VERSION_17

group = "com.digi.delivery"
version = "1.0"

repositories {
    mavenCentral()
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    implementation("com.microsoft.sqlserver:mssql-jdbc:11.2.3.jre17")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.modelmapper:modelmapper:2.1.1")
    implementation("io.jsonwebtoken:jjwt-api:0.10.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.10.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.10.5")

    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-common:2.9.2")

//    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-sqlserver")

//    implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
//    implementation("ch.qos.logback:logback-classic:1.2.6")

    // Swagger/OpenAPI
    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.6")

    implementation("org.apache.poi:poi-ooxml:5.2.2")
    // JUnit Jupiter API and Engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    // Mockito for mocking
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    // Assertions
    testImplementation("org.assertj:assertj-core:3.18.1")


    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    runtimeOnly("org.postgresql:postgresql")

    compileOnly("org.projectlombok:lombok:1.18.22")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17" // Target Java 17
    }
}

tasks.jar {
    archiveBaseName = "app"
    version = "1.0-SNAPSHOT"
}

val isWindows = System.getProperty("os.name").toLowerCase().contains("windows")

tasks.register<Exec>("pullLatestCode") {
    group = "custom"
    description = "stash local changes then pull the latest code from git repository"
    if (isWindows) {
        commandLine("cmd", "/c", "git stash && git fetch --all && git pull && git stash pop")
    } else {
        commandLine("bash", "-c", """
        git stash &&
        git fetch --all &&
        git pull &&
        git stash pop
    """.trimIndent())
    }
}

tasks.register("checkEnvVariables") {
    group = "custom"
    description = "Check required environment variables."
    doFirst {
        val requiredVars = listOf("DATABASE_USERNAME", "ACCESS_TOKEN_EXPIRED")
        requiredVars.forEach {
            requireNotNull(System.getenv(it)) { "Environment variable $it is not set." }
        }
    }
}

tasks.register("buildApplication") {
    dependsOn("pullLatestCode")
    group = "build"
    description = "Builds the Kotlin application."
    doLast {
        if (isWindows) {
            exec {
                commandLine("cmd", "/c", "gradlew.bat build")
            }
        } else {
            exec {
                commandLine("./gradlew", "build")
            }
        }
    }
}

tasks.register("runApp") {
    dependsOn("buildApplication")
    group = "run"
    description = "Runs the Kotlin application."
    doLast {
        exec {
            commandLine("java", "-jar", "build/libs/${project.name}-${project.version}-SNAPSHOT.jar")
        }
    }
}
