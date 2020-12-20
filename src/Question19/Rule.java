package Question19;

import java.util.HashMap;

public class Rule {

    HashMap<Integer, String> rule = new HashMap<>();

    void addRule(String rule){
        String[] parts = rule.split(":");
        if (Integer.parseInt(parts[0]) == 8){
            this.rule.put(8, "( 42 )+");
        }
        else if (Integer.parseInt(parts[0]) == 11){
            this.rule.put(11, "( 42 {1} 31 {1}| 42 {2} 31 {2}| 42 {3} 31 {3}| 42 {4} 31 {4}| 42 {5} 31 {5})");
//            this.rule.put(11, "( 42 + 31 +)");
        }
        else
            this.rule.put(Integer.parseInt(parts[0]), parts[1].trim());
    }
}
