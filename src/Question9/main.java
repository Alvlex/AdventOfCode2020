package Question9;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q9.txt");
        Preamble p = new Preamble();
        for (int i = 0; i < 25; i ++){
            p.add(Long.parseLong(input.get(i)));
        }
        long errorNum = 0;
        for (int i = 25; i < input.size(); i ++) {
            if (!p.isValid(Long.parseLong(input.get(i)))){
                errorNum = Long.parseLong(input.get(i));
                break;
            }
            else
                p.add(Long.parseLong(input.get(i)));
        }
        System.out.println(errorNum);
        for (int i = 0; i < input.size(); i ++){
            int j = i;
            long contiguous = Long.parseLong(input.get(j));
            long smallest = contiguous;
            long largest = contiguous;
            while(contiguous < errorNum){
                j ++;
                contiguous += Long.parseLong(input.get(j));
                if (Long.parseLong(input.get(j)) > largest)
                    largest = Long.parseLong(input.get(j));
                if (Long.parseLong(input.get(j)) < smallest)
                    smallest = Long.parseLong(input.get(j));
            }
            if (contiguous == errorNum){
                System.out.println(smallest + largest);
                break;
            }
        }

    }
}
