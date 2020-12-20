package Question19;

import java.util.ArrayList;
import java.util.HashSet;

public class Parse {

    String currentStep;
    Rule r;
    String finalString;

    Parse(Rule r){
        this.r = r;
        currentStep = "0";
    }

    void nextStep(){
        String[] parts = currentStep.split(" ");
        String nextStep = "";
        for (String part: parts){
            if (part.matches("\\d+")){
                nextStep += "( " + r.rule.get(Integer.parseInt(part)) + " ) ";
            }
            else{
                nextStep += part + " ";
            }
        }
        currentStep = nextStep.trim();
    }

    void run1000(){
        for (int i = 0; i < 100; i ++){
            nextStep();
        }
        finalString = currentStep.replaceAll("\"", "").replaceAll(" ", "");
    }

    boolean check(String s){
        return s.matches(finalString);
    }
}
