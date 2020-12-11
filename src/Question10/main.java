package Question10;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q10.txt");
        Chain c = new Chain(input);
        int[] result = c.getDifferences();
        System.out.println(result[0] * result[2]);
        System.out.println(c.noOfWays());
    }
}
