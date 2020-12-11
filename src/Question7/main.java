package Question7;

import common.Input;

import java.util.ArrayList;
import java.util.HashSet;

public class main {

    public static void main(String[] args){
        ArrayList<Rule> rules = new ArrayList<>();
        ArrayList<String> input = Input.getInput("Q7.txt");
        for (String line: input){
            rules.add(new Rule(line));
        }

        HashSet<String> containsGold = new HashSet<>();
        for (Rule r: rules){
            if (r.getResult().contains("shiny gold")){
                containsGold.add(r.getInput());
            }
        }
        boolean flag = false;
        while(!flag) {
            flag = true;
            for (Rule r : rules) {
                for (String s : r.getResult()) {
                    if (containsGold.contains(s)) {
                        if (containsGold.add(r.getInput()))
                            flag = false;
                        break;
                    }
                }
            }
        }
        System.out.println(containsGold.size());

        // Second part

        int total = -1;
        ArrayList<String> unpackedBags = new ArrayList<>();
        unpackedBags.add("shiny gold");
        while (!unpackedBags.isEmpty()){
            String type = unpackedBags.remove(0);
            for (Rule r: rules){
                if (r.getInput().contains(type)){
                    total ++;
                    unpackedBags.addAll(r.getResult());
                    break;
                }
            }
        }
        System.out.println(total);
    }
}
