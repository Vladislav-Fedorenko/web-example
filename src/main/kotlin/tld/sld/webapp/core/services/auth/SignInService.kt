package tld.sld.webapp.core.services.auth

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import tld.sld.webapp.core.models.SignInModel
import tld.sld.webapp.core.repositories.RepositoryException
import tld.sld.webapp.core.repositories.user.FindUserRepository
import tld.sld.webapp.core.services.ServiceException
import tld.sld.webapp.web.models.forms.SignInForm
import tld.sld.webapp.web.security.JwtService
import kotlin.jvm.Throws

interface SignInService {
    fun signIn(form: SignInForm): SignInModel
}

@Service
class SignInServiceImpl(
    private val findUserRepository: FindUserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
) : SignInService {
    override fun signIn(form: SignInForm): SignInModel {
        try {
            val user = findUserRepository.findByEmail(form.email)
            if (user == null) {
                throw SignInFailedException("User with email='${form.email}' not found")
            }
            if (!passwordEncoder.matches(form.password, user.password)) {
                throw SignInFailedException("Wrong password")
            }
            return SignInModel(
                jwt = jwtService.generateToken(user)
            )
        } catch (e: RepositoryException) {
            throw ServiceException("Failed to sign in with email='${form.email}'", e)
        }
    }

}