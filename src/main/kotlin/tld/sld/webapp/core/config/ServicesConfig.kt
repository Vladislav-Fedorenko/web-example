package tld.sld.webapp.core.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tld.sld.webapp.core.repositories.auth.SignUpRepository
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.TimestampGetterServiceImpl
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.core.services.UUIDGeneratorServiceImpl
import tld.sld.webapp.core.services.auth.SignUpService
import tld.sld.webapp.core.services.auth.SignUpServiceImpl

@Configuration
class ServicesConfig {
    @Bean
    fun timestampGetterService(): TimestampGetterService {
        return TimestampGetterServiceImpl()
    }

    @Bean
    fun uuidGeneratorService(): UUIDGeneratorService {
        return UUIDGeneratorServiceImpl()
    }
}