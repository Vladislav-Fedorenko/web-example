package tld.sld.webapp.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.NegatedRequestMatcher
import tld.sld.webapp.web.security.*

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val jwtService: JwtService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests().antMatchers(
                "/sign-in",
                "/sign-up"
            ).permitAll()
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .addFilterBefore(
                HeaderJwtAuthenticationFilter("/sign-in"),
                FilterSecurityInterceptor::class.java
            )
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(JwtAuthenticatiionProvider(jwtService))
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}