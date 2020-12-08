package Question1;

import java.util.ArrayList;

public class dataStructure {
    ArrayList<Integer> seen;

    dataStructure(){
        seen = new ArrayList<>();
    }

    void add(int number1) throws Answer{
        for (int number2: seen){
            if (number1 + number2 == 2020){
                throw new Answer(number1 * number2);
            }
        }
        seen.add(number1);
    }
}
