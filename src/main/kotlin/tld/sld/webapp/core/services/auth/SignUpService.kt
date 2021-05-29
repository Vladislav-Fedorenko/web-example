package tld.sld.webapp.core.services.auth

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import tld.sld.webapp.core.entities.UserEntity
import tld.sld.webapp.core.repositories.RepositoryException
import tld.sld.webapp.core.repositories.user.CreateUserRepository
import tld.sld.webapp.core.services.ServiceException
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.web.models.forms.SignUpForm

interface SignUpService {
    fun signUp(form: SignUpForm): Boolean
}

@Service
class SignUpServiceImpl(
    private val repository: CreateUserRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val uuidGeneratorService: UUIDGeneratorService,
    private val timestampGetterService: TimestampGetterService
) : SignUpService {
    override fun signUp(form: SignUpForm): Boolean {
        try {
            val now = timestampGetterService.get()
            return repository.create(UserEntity(
                id = uuidGeneratorService.generate(),
                createdAt = now,
                updatedAt = now,
                email = form.email,
                password = bCryptPasswordEncoder.encode(form.password)
            ))
        } catch (e: RepositoryException) {
            throw ServiceException("Failed to sign up user", e)
        }
    }
}