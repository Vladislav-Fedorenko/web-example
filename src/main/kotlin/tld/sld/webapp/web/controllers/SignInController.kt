package tld.sld.webapp.web.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import tld.sld.webapp.core.models.SignInModel
import tld.sld.webapp.core.services.ServiceException
import tld.sld.webapp.core.services.auth.SignInService
import tld.sld.webapp.web.models.forms.SignInForm
import tld.sld.webapp.web.models.responses.BaseResponse

@Controller
class SignInController(
    private val service: SignInService
) {
    @PostMapping(value = ["/sign-in"])
    fun signIn(@RequestBody form: SignInForm): ResponseEntity<BaseResponse<SignInModel>> {
        try {
            return ResponseEntity(
                BaseResponse(success = true, data = service.signIn(form), errorMessage = null, errors = null),
                HttpStatus.OK
            )
        } catch (e: ServiceException) {
            return ResponseEntity(
                BaseResponse(success = false, data = null, errorMessage = e.message, errors = mapOf("exception" to e.cause.toString())),
                HttpStatus.UNPROCESSABLE_ENTITY
            )
        }
    }
}