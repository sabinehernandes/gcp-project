package gcp.chili;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GreetLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String log;


    public GreetLog() {

    }


    public GreetLog(String log) {
        this.log = log;
    }
}
