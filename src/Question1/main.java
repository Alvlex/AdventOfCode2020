package Question1;

import java.util.ArrayList;
import common.Input;

public class main {

    public static void main(String[] args){
        ArrayList<String> inputs = Input.getInput("Q1.txt");
        dataStructure ds = new dataStructure();
        for (String input: inputs){
            try{
                ds.add(Integer.parseInt(input));
            }
            catch(Answer e){
                System.out.println(e.getMessage());
            }
        }
        Part2 p2 = new Part2();
        for (String input: inputs){
            try{
                p2.add(Integer.parseInt(input));
            }
            catch(Answer e){
                System.out.println(e.getMessage());
            }
        }
    }


}
