package tld.sld.webapp.core.services.auth

import tld.sld.webapp.core.entities.UserEntity
import tld.sld.webapp.core.repositories.auth.SignUpRepository
import tld.sld.webapp.core.services.TimestampGetterService
import tld.sld.webapp.core.services.UUIDGeneratorService
import tld.sld.webapp.web.models.forms.SignUpForm

interface SignUpService {
    fun signUp(form: SignUpForm): Boolean
}

class SignUpServiceImpl(
    private val repository: SignUpRepository,
    private val uuidGeneratorService: UUIDGeneratorService,
    private val timestampGetterService: TimestampGetterService
) : SignUpService {
    override fun signUp(form: SignUpForm): Boolean {
        val now = timestampGetterService.get()
        return repository.signUp(UserEntity(
            id = uuidGeneratorService.generate(),
            createdAt = now,
            updatedAt = now,
            username = form.username!!,
            password = form.password!!
        ))
    }

}