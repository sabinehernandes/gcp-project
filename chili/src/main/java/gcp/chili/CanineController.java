package gcp.chili;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canines")
public class CanineController {
    CanineRepository repo;

    public CanineController(CanineRepository repo) {
        this.repo = repo;
    }

    @PostMapping()
    public ResponseEntity<Canine> addDog(@RequestBody CanineDto request) {
        Canine doggy = repo.save(new Canine(request.name(), request.breed(), request.age()));
        return ResponseEntity.created(URI.create(doggy.getId())).body(doggy);
    }

    // make another endpoint that handles the file....

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDog(@PathVariable String id){
        Optional<Canine> doggy = repo.findById(id);
        if(doggy.isPresent()) {
            repo.delete(doggy.get());
            return ResponseEntity.ok().build();
        }
      return ResponseEntity.notFound().build();

    }
    @GetMapping()
    public ResponseEntity<List<Canine>> findAll(){

        return ResponseEntity.ok().body(repo.findAll());

    }



}
