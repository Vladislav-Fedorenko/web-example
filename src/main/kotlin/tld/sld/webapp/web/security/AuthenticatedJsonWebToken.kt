package tld.sld.webapp.web.security

import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority

class AuthenticatedJsonWebToken: AbstractAuthenticationToken {
    private val subject: String

    constructor(subject: String, authorities: MutableCollection<out GrantedAuthority>?) : super(authorities) {
        this.subject = subject
        super.setAuthenticated(true)
    }

    override fun getCredentials() = null

    override fun getPrincipal() = subject

}