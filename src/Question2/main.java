package Question2;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q2.txt");
        int counts = 0;
        Part1 p1 = new Part1();
        for (String line: input){
            counts = p1.parse(line) ? counts + 1 : counts;
        }
        System.out.println(counts);
        Part2 p2 = new Part2();
        counts = 0;
        for (String line: input){
            counts = p2.parse(line) ? counts + 1 : counts;
        }
        System.out.println(counts);
    }

}
