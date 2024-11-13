package gcp.chili;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/canines")
public class CanineController {
    CanineRepository repo;

    public CanineController(CanineRepository repo) {
        this.repo = repo;
    }

    @PostMapping()
    public ResponseEntity<Canine> addDog(@RequestBody CanineDto request) {
        Canine doggy = repo.save(new Canine(request.name(), request.breed(), request.age(), request.imageUrl()));
        return ResponseEntity.created(URI.create(doggy.getId())).body(doggy);
    }
}
