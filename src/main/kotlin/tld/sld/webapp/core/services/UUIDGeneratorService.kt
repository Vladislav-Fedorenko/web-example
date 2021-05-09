package tld.sld.webapp.core.services

import java.util.UUID

interface UUIDGeneratorService {
    fun generate(): String
}

class UUIDGeneratorServiceImpl : UUIDGeneratorService {
    override fun generate(): String {
        return UUID.randomUUID().toString()
    }
}