package Question4;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q4.txt");
        StringBuilder sb = new StringBuilder();
        int valid = 0;
        int valid2 = 0;
        for (String line: input){
            if (line.equals("")){
                Passport p = new Passport(sb.toString());
                PassportPart2 p2 = new PassportPart2(sb.toString());
                valid = p.isValid() ? valid + 1 : valid;
                valid2 = p2.isValid() ? valid2 + 1 : valid2;
                sb.delete(0, sb.length());
            }
            else{
                sb.append(line).append(" ");
            }
        }
        System.out.println(valid);
        System.out.println(valid2);
    }

}
