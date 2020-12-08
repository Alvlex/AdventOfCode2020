package Question3;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        ArrayList<String> input = Input.getInput("Q3.txt");
        Part1 p1 = new Part1();
        System.out.println(p1.path(input, 3));
        Part2 p2 = new Part2();
        long result = 1;
        for (int gradient = 1; gradient <= 7; gradient += 2){
            result = result * p2.path(input, gradient, 1);
        }
        result = result * p2.path(input, 2, 0);
        System.out.println(result);
    }
}
