package tld.sld.webapp.core.repositories.user

import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import tld.sld.webapp.core.entities.UserEntity
import tld.sld.webapp.core.repositories.RepositoryException

interface CreateUserRepository {
    fun create(entity: UserEntity): Boolean
}

class CreateUserRepositoryImpl(
    private val jdbc: JdbcTemplate
) : CreateUserRepository {
    private val log = LoggerFactory.getLogger(this::class.simpleName)

    override fun create(entity: UserEntity): Boolean {
        try {
            val result = jdbc.update("""
                INSERT INTO users (id, email, password, created_at, updated_at)
                VALUES (?, ?, ?, ?, ?)
            """, entity.id, entity.email, entity.password, entity.createdAt, entity.updatedAt)
            return result == 1;
        } catch (e: DataAccessException) {
            throw RepositoryException("Failed to create user", e)
        }
    }
}