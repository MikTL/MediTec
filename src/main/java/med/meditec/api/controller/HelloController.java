package med.meditec.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller --> Versiones antiguas
@RestController
@RequestMapping("/hello")

public class HelloController {
    @GetMapping // GET method
    public String helloWorld() {
        return "<h1>Hello World!!!</h1>";
    }
}
