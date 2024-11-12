package gcp.chili;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    String greeting = "Hello";
    GreetingService greetingService;

    public Controller(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet/{name}")
    public String getGreeting(@PathVariable String name) {
        greetingService.saveGreet(greeting + " " + name);
        return greeting + " " + name;
    }

    @GetMapping("/change/{hej}")
    public String getHej(@PathVariable String hej) {
        greeting = hej;
        return greeting;
    }

    @GetMapping("/getAll")
    public List<String> getAll() {
        return greetingService.getGreetings();
    }
}
