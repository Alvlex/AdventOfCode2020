package Question18;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> expressions = Input.getInput("Q18.txt");
        long total = 0;
        long total2 = 0;
        for (String expr: expressions){
            Expression e = new Expression(expr);
            Expression2 e2 = new Expression2(expr);
            while(e.subprocess()){
            }
            total += e.process();
            while(e2.subprocess()){

            }
            total2 += e2.process();
        }
        System.out.println(total);
        System.out.println(total2);
    }
}
