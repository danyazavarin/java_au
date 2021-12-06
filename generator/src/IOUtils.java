import java.io.*;
import java.util.*;

public class

IOUtils {
    static List<String> readData(String input_filename){
        List<String> data = new ArrayList<>();
        try {
            File file = new File(input_filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                data.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    static void writeData(String output_filename, String data) {
        File file = new File(output_filename);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}