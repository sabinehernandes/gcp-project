package gcp.chili;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import java.io.File;

@Entity
public class Canine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String breed;
    private int age;
    @Column(nullable = true)
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Canine(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Canine() {
    }
}
