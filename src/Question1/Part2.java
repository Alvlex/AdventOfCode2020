package Question1;

import java.util.ArrayList;
import java.util.Arrays;

public class Part2 {
    ArrayList<Integer> seen;

    Part2(){
        seen = new ArrayList<>();
    }

    void add(int number1) throws Answer{
        for (int number2: seen){
            for (int number3: seen) {
                if (number2 != number3) {
                    if (number1 + number2 + number3 == 2020) {
                        throw new Answer(number1 * number2 * number3);
                    }
                }
            }
        }
        seen.add(number1);
    }
}
