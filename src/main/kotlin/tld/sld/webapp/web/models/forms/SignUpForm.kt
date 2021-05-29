package tld.sld.webapp.web.models.forms

data class SignUpForm(
    var email: String,
    var password: String
) {
    override fun toString(): String {
        return "SignUpForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}