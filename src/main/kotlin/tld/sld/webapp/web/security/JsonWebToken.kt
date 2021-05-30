package tld.sld.webapp.web.security

import org.springframework.security.authentication.AbstractAuthenticationToken
import java.lang.IllegalArgumentException

class JsonWebToken : AbstractAuthenticationToken {
    private val token: String

    constructor(token: String) : super(null) {
        this.token = token
        super.setAuthenticated(false)
    }

    override fun setAuthenticated(authenticated: Boolean) {
        if (authenticated) {
            throw IllegalArgumentException("Cannot set this token to trusted")
        }
        super.setAuthenticated(false)
    }

    override fun getCredentials() = token

    override fun getPrincipal() = null
}