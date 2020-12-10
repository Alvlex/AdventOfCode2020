package Question4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PassportPart2 {

    private HashMap<String, String> details;

    PassportPart2(String input){
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
                validBirth(details.get("byr")) &&
                keys.contains("iyr") &&
                validIssue(details.get("iyr")) &&
                keys.contains("eyr") &&
                validExpire(details.get("eyr")) &&
                keys.contains("hgt") &&
                validHeight(details.get("hgt")) &&
                keys.contains("hcl") &&
                validHair(details.get("hcl")) &&
                keys.contains("ecl") &&
                validEye(details.get("ecl")) &&
                keys.contains("pid") &&
                id(details.get("pid"));
    }

    private boolean validBirth(String byr){
        try {
            int byrI = Integer.parseInt(byr);
            return 1920 <= byrI && byrI <= 2002;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean validIssue(String iyr){
        try {
            int iyrI = Integer.parseInt(iyr);
            return 2010 <= iyrI && iyrI <= 2020;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean validExpire(String eyr){
        try {
            int eyrI = Integer.parseInt(eyr);
            return 2020 <= eyrI && eyrI <= 2030;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean validHeight(String hgt){
        String end = hgt.substring(hgt.length() - 2);
        int lowerBound, upperBound;
        switch (end) {
            case "cm":
                lowerBound = 150;
                upperBound = 193;
                break;
            case "in":
                lowerBound = 59;
                upperBound = 76;
                break;
            default:
                return false;
        }
        try {
            int hgtI = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            return lowerBound <= hgtI && hgtI <= upperBound;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean isHex(char c){
        return Character.digit(c, 16) != -1;
    }

    private boolean validHair(String hcl){
        if (hcl.length() != 7)
            return false;
        if (hcl.charAt(0) != '#')
            return false;
        for (int i = 1; i < hcl.length(); i ++){
            if (!isHex(hcl.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean validEye(String ecl){
        Set<String> eyeColours = new HashSet<String>();
        eyeColours.add("amb");
        eyeColours.add("blu");
        eyeColours.add("brn");
        eyeColours.add("gry");
        eyeColours.add("grn");
        eyeColours.add("hzl");
        eyeColours.add("oth");
        return eyeColours.contains(ecl);
    }

    private boolean id(String pid){
        if (pid.length() != 9)
            return false;
        for (char c: pid.toCharArray())
            if (!Character.isDigit(c))
                return false;
        return true;
    }
}
