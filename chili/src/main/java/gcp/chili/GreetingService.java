package gcp.chili;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    Repository repository;

    public GreetingService(Repository repository) {
        this.repository = repository;
    }

    public void saveGreet(String greet) {
        repository.save(new GreetLog(greet));
    }

    public List<String> getGreetings() {
        return repository.findAll().stream()
                .map(str -> str.getLog())
                .toList();

    }
}
