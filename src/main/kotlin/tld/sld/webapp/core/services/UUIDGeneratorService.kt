package tld.sld.webapp.core.services

import java.util.*

interface UUIDGeneratorService {
    fun generate(): UUID
}

class UUIDGeneratorServiceImpl : UUIDGeneratorService {
    override fun generate(): UUID {
        return UUID.randomUUID()
    }
}