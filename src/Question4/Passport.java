package Question4;

import java.util.HashMap;
import java.util.Set;

class Passport {

    private HashMap<String, String> details;

    Passport(String input){
        details = new HashMap<>();
        String[] fields = input.split(" ");
        for (String field: fields){
            String[] pair = field.split(":");
            details.put(pair[0], pair[1]);
        }
    }

    boolean isValid(){
        Set<String> keys = details.keySet();
        return keys.contains("byr") &&
                keys.contains("iyr") &&
                keys.contains("eyr") &&
                keys.contains("hgt") &&
                keys.contains("hcl") &&
                keys.contains("ecl") &&
                keys.contains("pid");
    }
}
