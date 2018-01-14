import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class Util {

    //3
    public static void printYoutubeJSON(String destination) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Youtube youtube = objectMapper.readValue(new File(destination), Youtube.class);
            System.out.println(youtube);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //4
    public static void convertYoutubeJSONToXML(String JSONFile, String XMLFile) {

        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(JSONFile);
            fout = new FileOutputStream(XMLFile);

            int i;
            String JSONTOString = "";
            while ((i = fin.read()) !=-1) {
                //hozzáírja a i-edik charactert a változóba
                JSONTOString+= (char)i;
            }

            //a JSON objektum létrehozása
            JSONObject json = new JSONObject(JSONTOString);
            //konvertálás xml-be
            String xml = XML.toString(json);
            //fájlba írás
            fout.write(xml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
