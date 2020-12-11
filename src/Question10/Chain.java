package Question10;

import java.util.ArrayList;
import java.util.Arrays;

public class Chain {

    int[] jolts;

    Chain(ArrayList<String> input){
        jolts = new int[input.size() + 1];
        for (int i = 0; i < input.size(); i ++){
            jolts[i] = Integer.parseInt(input.get(i));
        }
        jolts[input.size()] = Integer.MAX_VALUE;
        Arrays.sort(jolts);
        jolts[input.size()] = 3 + jolts[input.size() - 1];
    }

    int[] getDifferences(){
        int joltage = 0;
        int[] result = new int[3];
        for (int i: jolts){
            result[i - joltage - 1] ++;
            joltage = i;
        }
        return result;
    }

    // Part 2

    long noOfWays() {
        int[] temp = {2,4,7};
        long ways = 1;
        int run = 0;
        int acc = 0;
        for (int jolt : jolts) {
            if (acc == jolt - 1) {
                run++;
            } else if (acc == jolt - 3){
                if (run >= 2)
                    ways *= temp[run - 2];
                run = 0;
            }
            acc = jolt;
        }
        return ways;
    }



}
