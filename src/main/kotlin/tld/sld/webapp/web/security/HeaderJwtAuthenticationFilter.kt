package tld.sld.webapp.web.security

import org.springframework.security.web.util.matcher.RequestMatcher
import javax.servlet.http.HttpServletRequest

class HeaderJwtAuthenticationFilter(path: String) : JwtAuthenticationFilter(path) {
    override fun extractToken(request: HttpServletRequest): String {
        val authHeader = request.getHeader("Authorization")
        return authHeader.trim().split(" ").last()
    }
}
