package tld.sld.webapp.web.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication

class JwtAuthenticatiionProvider(
    private val jwtService: JwtService
) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        try {
            return jwtService.parseToken(token = authentication.credentials as String)
        } catch (e: Exception) {
            throw JwtAuthenticationException("Invalid token received")
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return JsonWebToken::class.java.isAssignableFrom(authentication)
    }

}