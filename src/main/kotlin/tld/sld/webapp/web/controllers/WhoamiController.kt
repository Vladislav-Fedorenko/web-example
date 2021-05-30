package tld.sld.webapp.web.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import tld.sld.webapp.core.models.SignInModel
import tld.sld.webapp.core.services.ServiceException
import tld.sld.webapp.core.services.auth.SignInService
import tld.sld.webapp.web.models.forms.SignInForm
import tld.sld.webapp.web.models.responses.BaseResponse

@Controller
class WhoamiController {
    @GetMapping(value = ["/whoami"])
    fun whoAmI(): ResponseEntity<BaseResponse<String>> {
        return ResponseEntity(
            BaseResponse(success = true, data = "You are authenticated user", errorMessage = null, errors = null),
            HttpStatus.OK
        )
    }
}