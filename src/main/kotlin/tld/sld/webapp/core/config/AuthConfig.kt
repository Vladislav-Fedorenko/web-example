package tld.sld.webapp.core.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import tld.sld.webapp.core.repositories.user.CreateUserRepository
import tld.sld.webapp.core.repositories.user.CreateUserRepositoryImpl
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.core.services.auth.SignUpService
import tld.sld.webapp.core.services.auth.SignUpServiceImpl

@Configuration
class AuthConfig {
    @Bean
    fun createUserRepository(jdbc: JdbcTemplate): CreateUserRepository {
        return CreateUserRepositoryImpl(jdbc = jdbc)
    }

    @Bean
    fun signUpService(
        repository: CreateUserRepository,
        bCryptPasswordEncoder: BCryptPasswordEncoder,
        uuidGeneratorService: UUIDGeneratorService,
        timestampGetterService: TimestampGetterService,
    ): SignUpService {
        return SignUpServiceImpl(
            repository = repository,
            bCryptPasswordEncoder = bCryptPasswordEncoder,
            uuidGeneratorService = uuidGeneratorService,
            timestampGetterService = timestampGetterService
        )
    }
}