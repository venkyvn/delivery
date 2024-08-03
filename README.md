## Enable HTTPS for Spring Boot App by Configuring SSL With Base64-encoded PEM Certificates

1. Create **Base64 PEM format** `the unencrypted private key (server.key)` and `the self-signed certificate (server.crt)` for configuring SSL by using **openssl**
```shell
openssl req -newkey rsa:2048 -x509 -sha256 -days 365 -nodes -keyout server.key -out server.crt -subj "/CN=self-signed-localhost"
```

2. Convert it to p12 type
```shell
openssl pkcs12 -export -in server.crt -inkey server.key -out keystore.p12 -name alias -password pass:123456
```


