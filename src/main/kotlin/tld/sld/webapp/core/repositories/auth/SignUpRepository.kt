package tld.sld.webapp.core.repositories.auth

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcTemplate
import tld.sld.webapp.core.entities.UserEntity

interface SignUpRepository {
    fun signUp(entity: UserEntity): Boolean
}

class SignUpRepositoryImpl(
    private val jdbc: JdbcTemplate,
    private val mapper: ObjectMapper
) : SignUpRepository {
    private val log = LoggerFactory.getLogger(this::class.simpleName)

    override fun signUp(entity: UserEntity): Boolean {
        val query = "INSERT INTO users (document) VALUES (?::JSONB)"
        val document = mapper.writeValueAsString(entity)
        log.info("SQL = {}, document = {}", query, document)
        val result = jdbc.update(query, document)
        return result == 1;
    }
}