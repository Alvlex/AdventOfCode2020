package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {

    public static ArrayList<String> getInput(String file){
        InputStream in = Input.class.getClassLoader().getResourceAsStream(file);
        ArrayList<String> inputs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                inputs.add(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return inputs;
    }
}
