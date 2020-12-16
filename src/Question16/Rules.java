package Question16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Rules {
    ArrayList<Rule> rules = new ArrayList<>();

    void addRule(Rule r){
        rules.add(r);
    }

    int getErrors(String line){
        int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        int total = -1;
        boolean valid = true;
        for (int num: nums){
            if (!isValid(num)) {
                valid = false;
                total += num;
            }
        }
        if (!valid){
            total += 1;
        }
        return total;
    }

    Rule getRule(int i){
        for (Rule r: rules){
            if (r.descriptionIncludes(i))
                return r;
        }
        return null;
    }

    boolean isValid(int num){
        for (Rule r: rules){
            if (r.inRange(num))
                return true;
        }
        return false;
    }
}
