package tld.sld.webapp.core.repositories.user

import org.postgresql.util.PSQLException
import org.slf4j.LoggerFactory
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import tld.sld.webapp.core.entities.UserEntity
import tld.sld.webapp.core.repositories.RepositoryException

interface CreateUserRepository {
    fun create(entity: UserEntity): Boolean
}

@Repository
class CreateUserRepositoryImpl(
    private val jdbc: JdbcTemplate
) : CreateUserRepository {
    private val log = LoggerFactory.getLogger(this::class.simpleName)
    private val DUBLICATE_KEY_SQL_STATE = "23505"

    override fun create(entity: UserEntity): Boolean {
        try {
            val result = jdbc.update("""
                INSERT INTO users (id, email, password, created_at, updated_at)
                VALUES (?, ?, ?, ?, ?)
            """, entity.id, entity.email, entity.password, entity.createdAt, entity.updatedAt)
            return result == 1;
        } catch (e: DataAccessException) {
            if (e is PSQLException) {
                if (e.sqlState.equals(DUBLICATE_KEY_SQL_STATE)) {
                    throw EmailExistsException("User with email = '${entity.email}' already exists", e)
                }
            }
            throw RepositoryException("Failed to create user", e)
        }
    }
}