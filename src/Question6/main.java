package Question6;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q6.txt");
        StringBuilder sb = new StringBuilder();
        int total = 0;
        int total2 = 0;
        for(String line: input){
            if (line.equals("")){
                Group g = new Group(sb.toString());
                Group2 g2 = new Group2(sb.toString());
                total += g.getNo();
                total2 += g2.getNo();
                sb.delete(0, sb.length());
            }
            else{
                sb.append(line).append(" ");
            }
        }
        System.out.println(total);
        System.out.println(total2);

    }
}
