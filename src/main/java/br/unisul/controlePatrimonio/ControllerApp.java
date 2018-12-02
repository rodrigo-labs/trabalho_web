package br.unisul.controlePatrimonio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerApp {

    @GetMapping
    public String index() {
        return "index";
    }
}
