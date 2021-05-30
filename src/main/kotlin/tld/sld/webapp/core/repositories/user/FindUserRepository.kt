package tld.sld.webapp.core.repositories.user

import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import tld.sld.webapp.core.entities.UserEntity
import tld.sld.webapp.core.repositories.RepositoryException
import java.util.*

interface FindUserRepository {
    fun findByEmail(email: String): UserEntity?
}

@Repository
class FindUserRepositoryImpl(
    private val jdbc: JdbcTemplate
) : FindUserRepository {
    override fun findByEmail(email: String): UserEntity? {
        try {
            return jdbc.query(
                """
                    SELECT
                        id,
                        email,
                        password,
                        created_at,
                        updated_at
                    FROM users 
                    WHERE email = ?
                """.trimIndent(),
                {rs, _ -> UserEntity(
                    id = UUID.fromString(rs.getString(1)),
                    email = rs.getString(2),
                    password = rs.getString(3),
                    createdAt = rs.getTimestamp(4),
                    updatedAt = rs.getTimestamp(5),
                )},
                email
            ).singleOrNull()
        } catch (e: DataAccessException) {
            throw RepositoryException("Failed to find user with email='${email}'", e)
        }
    }
}