package Question14;

import common.Input;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q14.txt");
        AddressSpace as = new AddressSpace("");
        AddressSpace2 as2 = new AddressSpace2();
        for (String s: input){
            String[] parts = s.split(" = ");
            if (parts[0].contains("mask")){
                as.updateMask(parts[1].trim());
                as2.updateMask(parts[1].trim());
            }
            else{
                int add = Integer.parseInt(parts[0].substring(4, parts[0].length() - 1));
                as.addValue(add, Integer.parseInt(parts[1]));
                as2.addMemory(add, Integer.parseInt(parts[1]));
            }
        }
        System.out.println(as.sumAllVals());
        System.out.println(as2.getMemorySum());
    }
}