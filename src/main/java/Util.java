import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Util {

    //3
    public static void printYoutubeJSON(String destination) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Youtube youtube = objectMapper.readValue(new File(destination),Youtube.class);
            System.out.println(youtube);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
