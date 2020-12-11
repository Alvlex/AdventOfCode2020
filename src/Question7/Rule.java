package Question7;

import java.util.ArrayList;

public class Rule {

    private String input;
    private ArrayList<String> output;
    private ArrayList<Integer> outputNo;

    Rule(String rule){
        output = new ArrayList<>();
        outputNo = new ArrayList<>();
        String[] tokens = rule.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String s: tokens){
            if (input == null) {
                if (s.contains("bag")) {
                    input = sb.toString().trim();
                    sb.delete(0, sb.length());
                }
                else
                    sb.append(s).append(" ");
            }
            else {
                if (Character.isDigit(s.charAt(0))) {
                    flag = true;
                    outputNo.add(Integer.parseInt(s));
                } else if (s.contains("bag")) {
                    flag = false;
                    output.add(sb.toString().trim());
                    sb.delete(0, sb.length());
                } else if (flag) {
                    sb.append(s).append(" ");
                }
            }
        }
    }

    String getInput(){
        return input;
    }

    ArrayList<String> getResult(){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < outputNo.size(); i ++){
            for (int j = 0; j < outputNo.get(i); j ++){
                result.add(output.get(i));
            }
        }
        return result;
    }

}
