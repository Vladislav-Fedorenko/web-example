package tld.sld.webapp.web.models.forms

data class SignUpForm(
    var username: String? = null,
    var password: String? = null
) {
    override fun toString(): String {
        return "SignUpForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}