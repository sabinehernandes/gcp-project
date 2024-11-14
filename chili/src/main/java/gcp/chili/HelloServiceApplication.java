package gcp.chili;

import com.harium.supabase.SupabaseClient;
import com.harium.supabase.storage.Bucket;
import com.harium.supabase.storage.StorageAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class HelloServiceApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(HelloServiceApplication.class, args);

		// Starting the client
		SupabaseClient supabase = new SupabaseClient("https://cjwzbienfxxvqlvizeca.supabase.co", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNqd3piaWVuZnh4dnFsdml6ZWNhIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczMTUwNzQwMSwiZXhwIjoyMDQ3MDgzNDAxfQ.ZWnoP-mx7WnHO_nR57jbWUVBIpxz8QC1k-mxAbmB67E");

// Listing all buckets
		StorageAPI storageAPI = supabase.storage();
		List<Bucket> buckets = storageAPI.listBuckets();
		buckets.forEach(b -> System.out.println("b.name = " + b.name));
		buckets.forEach(b -> System.out.println("b.id = " + b.id));
		storageAPI.listFiles("chiliDogs").forEach(p -> System.out.println("picture name: "+p.name));
		storageAPI.listFiles("chiliDogs").forEach(p -> System.out.println("metadata: "+ p.updatedAt));
		Bucket buck = storageAPI.getBucket("chiliDogs");
//		System.out.println("bucket id" +buck.);
//		https://cjwzbienfxxvqlvizeca.supabase.co/storage/v1/object/public/chiliDogs/test.txt
//		https://cjwzbienfxxvqlvizeca.supabase.co/storage/v1/object/public/chiliDogs/20241023_183704.JPG?t=2024-11-13T14%3A31%3A00.902Z

//		BufferedImage image = ImageIO.read(new File("./resources/images/johnsDoggy.JPG"));

		// Upload a file
		storageAPI.upload("chiliDogs/test.txt", "heloo".getBytes());
//		storageAPI.upload("chiliDogs/doggy.jpg",image);
		File fi = new File("src/main/resources/images/johnsDoggy.JPG");
		byte[] fileContent = Files.readAllBytes(fi.toPath());
				storageAPI.upload("chiliDogs/doggy.jpg",fileContent);
				storageAPI.downl

	}

}
