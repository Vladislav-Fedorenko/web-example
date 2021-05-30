package tld.sld.webapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.TimestampGetterServiceImpl
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.core.services.UUIDGeneratorServiceImpl

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

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}