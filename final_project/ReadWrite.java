package final_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWrite {
    public static ArrayList<String> readAll(File file) {
        ArrayList<String> result = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while (true) {
                String temp = br.readLine();
                if (temp == null)
                    break;
                result.add(temp);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}