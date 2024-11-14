package gcp.chili;

import com.harium.supabase.SupabaseClient;
import com.harium.supabase.storage.StorageAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SupaService {

    SupabaseClient supabase = new SupabaseClient("https://cjwzbienfxxvqlvizeca.supabase.co", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNqd3piaWVuZnh4dnFsdml6ZWNhIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczMTUwNzQwMSwiZXhwIjoyMDQ3MDgzNDAxfQ.ZWnoP-mx7WnHO_nR57jbWUVBIpxz8QC1k-mxAbmB67E");
    String url = "https://cjwzbienfxxvqlvizeca.supabase.co/storage/v1/object/public/";
    StorageAPI storageAPI = supabase.storage();

    public String upload(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
        storageAPI.upload("chiliDogs/" + file.getName(), fileContent);
        return url + "chiliDogs/" + file.getName();
    }
}
