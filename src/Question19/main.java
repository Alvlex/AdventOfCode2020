package Question19;

import common.Input;

import java.util.ArrayList;
import java.util.HashSet;

public class main {


    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q19.txt");
        boolean outOfRules = false;
        ArrayList<String> toCheck = new ArrayList<>();
        Rule r = new Rule();
        int count = 0;
        for (String anInput : input) {
            if (anInput.equals("")) {
                outOfRules = true;
            } else if (!outOfRules) {
                r.addRule(anInput);
            } else {
                toCheck.add(anInput);
            }
        }
        Parse p = new Parse(r);
        p.run1000();
        for (String s: toCheck){
            if (p.check(s))
                count ++;
        }
        System.out.println(count);
    }
}
