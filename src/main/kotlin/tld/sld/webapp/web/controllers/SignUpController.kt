package tld.sld.webapp.web.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import tld.sld.webapp.core.services.auth.SignUpService
import tld.sld.webapp.web.models.forms.SignUpForm
import tld.sld.webapp.web.models.responses.BaseResponse

@Controller
class SignUpController(
    private val service: SignUpService
) {
    @PostMapping(value = ["/sign-up"])
    fun signUp(@RequestBody form: SignUpForm): ResponseEntity<BaseResponse<*>> {
        return ResponseEntity(
            BaseResponse(success = service.signUp(form), data = null, errorMessage = null, errors = null),
            HttpStatus.OK
        )
    }
}