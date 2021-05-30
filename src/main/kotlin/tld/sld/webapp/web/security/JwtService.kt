package tld.sld.webapp.web.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service
import tld.sld.webapp.core.entities.UserEntity
import java.time.Duration
import java.time.Instant
import java.util.*

interface JwtService {
    fun generateToken(user: UserEntity): String
    fun parseToken(token: String): Authentication
}

@Service
class JwtServiceImpl(
    private val jwtSettings: JwtSettings
) : JwtService {
    override fun generateToken(user: UserEntity): String {
        val now = Instant.now()
        val claims = Jwts.claims()
            .setIssuedAt(Date.from(now))
            .setSubject(user.email)
            .setExpiration(Date.from(now.plus(Duration.ofMinutes(jwtSettings.aTokenDuration))))

        return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, jwtSettings.signingKey)
            .compact()
    }

    override fun parseToken(token: String): Authentication {
        val claims = Jwts.parser().setSigningKey(jwtSettings.signingKey).parseClaimsJws(token)
        val subject = claims.body.subject
        return AuthenticatedJsonWebToken(subject = subject, authorities = mutableListOf<GrantedAuthority>())
    }
}