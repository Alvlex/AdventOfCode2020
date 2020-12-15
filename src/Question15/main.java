package Question15;

import common.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q15.txt");
        int[] numbers = Arrays.stream(input.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        Sequence s = new Sequence();
        long temp = numbers[0];
        for (int i = 0; i < numbers.length; i ++){
            temp = s.addNum(numbers[i]);
        }
        while(s.getCurrentPos() < 30000000){
            if (s.getCurrentPos() == 2020)
                System.out.println(temp);
            temp = s.addNum(temp);
        }
        System.out.println(temp);
    }
}
