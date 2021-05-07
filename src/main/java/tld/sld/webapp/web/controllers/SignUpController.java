package tld.sld.webapp.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tld.sld.webapp.web.models.forms.SignUpForm;
import tld.sld.webapp.web.models.responses.BaseResponse;

@Controller
public class SignUpController {
    @PostMapping(value = "/sign-up")
    public ResponseEntity<BaseResponse> signUp(@RequestBody final SignUpForm form) {
        return new ResponseEntity(
            BaseResponse.builder().success(true),
            HttpStatus.OK
        );
    }
}
