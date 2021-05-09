package tld.sld.webapp.core.services

import java.sql.Timestamp

interface TimestampGetterService {
    fun get(): String
}

class TimestampGetterServiceImpl : TimestampGetterService {
    override fun get(): String {
        return Timestamp(System.currentTimeMillis()).toInstant().toString()
    }

}