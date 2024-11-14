package gcp.chili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class HelloServiceApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(HelloServiceApplication.class, args);
	}
}
