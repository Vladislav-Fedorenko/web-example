package tld.sld.webapp.core.services.auth

import javax.naming.AuthenticationException

class SignInFailedException : AuthenticationException {
    constructor(explanation: String?) : super(explanation)
    constructor()
}