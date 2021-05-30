package tld.sld.webapp.web.security

import javax.naming.AuthenticationException

class JwtAuthenticationException : AuthenticationException {
    constructor(explanation: String?) : super(explanation)
    constructor() : super()
}
