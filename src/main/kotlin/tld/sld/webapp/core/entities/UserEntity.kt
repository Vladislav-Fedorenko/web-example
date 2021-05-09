package tld.sld.webapp.core.entities

data class UserEntity (
    override val id: String,
    override val createdAt: String,
    override val updatedAt: String,

    var username: String = "",
    var password: String = "",
) : Entity {
    override fun toString(): String {
        return "UserEntity(" +
            "id='$id'," +
            "createdAt='$createdAt'," +
            "updatedAt='$updatedAt'," +
            "username='$username'," +
            "password='$password'" +
         ")"
    }
}