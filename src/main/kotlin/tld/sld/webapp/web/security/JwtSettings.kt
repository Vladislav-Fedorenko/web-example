package tld.sld.webapp.web.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Duration

@Component
data class JwtSettings(
    @Value("\${jwt.signingKey}") val signingKey: String,
    @Value("\${jwt.aTokenDuration}") val aTokenDuration: Long
)