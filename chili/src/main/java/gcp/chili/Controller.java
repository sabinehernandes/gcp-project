package gcp.chili;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    String greeting = "Hello";

    @GetMapping("/{name}")
    public String getGreeting(@PathVariable String name) {
        return greeting + " " + name;
    }
}
