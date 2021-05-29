package tld.sld.webapp.core.services

import org.springframework.stereotype.Service
import java.sql.Timestamp

interface TimestampGetterService {
    fun get(): Timestamp
}

@Service
class TimestampGetterServiceImpl : TimestampGetterService {
    override fun get(): Timestamp {
        return Timestamp(System.currentTimeMillis())
    }
}