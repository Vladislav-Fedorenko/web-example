package tld.sld.webapp.core.services

import java.sql.Timestamp

interface TimestampGetterService {
    fun get(): Timestamp
}

class TimestampGetterServiceImpl : TimestampGetterService {
    override fun get(): Timestamp {
        return Timestamp(System.currentTimeMillis())
    }

}