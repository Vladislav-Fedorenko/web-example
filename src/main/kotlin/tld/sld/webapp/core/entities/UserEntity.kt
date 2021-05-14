package tld.sld.webapp.core.entities

import java.sql.Timestamp
import java.util.*

data class UserEntity (
    override val id: UUID,
    override val createdAt: Timestamp,
    override val updatedAt: Timestamp,

    var email: String = "",
    var password: String = "",
) : Entity {
    override fun toString(): String {
        return "UserEntity(" +
            "id='$id'," +
            "createdAt='$createdAt'," +
            "updatedAt='$updatedAt'," +
            "email='$email'," +
            "password='$password'" +
         ")"
    }
}