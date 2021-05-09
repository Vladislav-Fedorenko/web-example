package tld.sld.webapp.core.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import tld.sld.webapp.core.repositories.auth.SignUpRepository
import tld.sld.webapp.core.repositories.auth.SignUpRepositoryImpl
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.core.services.auth.SignUpService
import tld.sld.webapp.core.services.auth.SignUpServiceImpl

@Configuration
class AuthConfig {
    @Bean
    fun signUpRepository(jdbc: JdbcTemplate, mapper: ObjectMapper): SignUpRepository {
        return SignUpRepositoryImpl(jdbc = jdbc, mapper = mapper)
    }

    @Bean
    fun signUpService(
        repository: SignUpRepository,
        uuidGeneratorService: UUIDGeneratorService,
        timestampGetterService: TimestampGetterService,
    ): SignUpService {
        return SignUpServiceImpl(
            repository = repository,
            uuidGeneratorService = uuidGeneratorService,
            timestampGetterService = timestampGetterService
        )
    }
}