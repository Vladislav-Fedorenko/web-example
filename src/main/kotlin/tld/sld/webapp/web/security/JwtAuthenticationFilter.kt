package tld.sld.webapp.web.security

import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.AnyRequestMatcher
import org.springframework.security.web.util.matcher.NegatedRequestMatcher
import org.springframework.security.web.util.matcher.RequestMatcher
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class JwtAuthenticationFilter(path: String) : AbstractAuthenticationProcessingFilter(NegatedRequestMatcher(AntPathRequestMatcher(path))) {
    protected abstract fun extractToken(request: HttpServletRequest): String

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        return try {
            JsonWebToken(extractToken(request))
        } catch (e: Exception) {
            AnonymousAuthenticationToken("ANONYMOUS", "ANONYMOUS", mutableListOf(SimpleGrantedAuthority("ROLE_ANONYMOUS")))
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        SecurityContextHolder.getContext().authentication = authResult
        chain.doFilter(request, response)
    }
}