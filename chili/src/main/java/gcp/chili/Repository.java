package gcp.chili;

import org.springframework.data.repository.ListCrudRepository;

public interface Repository extends ListCrudRepository<GreetLog, Long> {
}
