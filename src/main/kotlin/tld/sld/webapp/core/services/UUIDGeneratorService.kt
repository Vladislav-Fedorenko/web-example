package tld.sld.webapp.core.services

import org.springframework.stereotype.Service
import java.util.UUID

interface UUIDGeneratorService {
    fun generate(): UUID
}

@Service
class UUIDGeneratorServiceImpl : UUIDGeneratorService {
    override fun generate(): UUID {
        return UUID.randomUUID()
    }
}