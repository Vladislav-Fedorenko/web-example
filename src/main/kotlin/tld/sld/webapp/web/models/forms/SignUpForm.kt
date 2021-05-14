package tld.sld.webapp.web.models.forms

data class SignUpForm(
    var email: String? = null,
    var password: String? = null
) {
    override fun toString(): String {
        return "SignUpForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}