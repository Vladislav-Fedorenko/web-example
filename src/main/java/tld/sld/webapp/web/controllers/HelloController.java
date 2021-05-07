package tld.sld.webapp.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping(
        value = "/hello",
        method = RequestMethod.GET
    )
    public ResponseEntity<String> hello(@RequestParam final String name) {
        return new ResponseEntity<>("Hello, " + name + "!", HttpStatus.OK);
    }
}
