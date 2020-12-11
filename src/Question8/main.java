package Question8;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q8.txt");
        Program p = new Program(input);
        System.out.println(p.runAll());
        Program2 p2 = new Program2(input);
        System.out.println(p2.runAll());
    }
}
