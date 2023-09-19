package util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class FileUtility {
    final static String filePath = "C:\\Workspace\\LanguageApp\\words.txt";
    public static Map<String, String> readFile() throws Exception {
        Map<String, String> getInfo = new HashMap<>();

        File fileName = new File(filePath);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String info;

            while ((info = bufferedReader.readLine()) != null) {
            String line = info.replace(" ","");
            String[] elements=line.split(",");
            String key = elements[0];
            String value = elements[1];
            if (!key.equals("") && !value.equals(""))
                getInfo.put(key, value);
            }
            return getInfo;
        }
    }
}
