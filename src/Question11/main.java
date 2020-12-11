package Question11;

import common.Input;

import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q11.txt");
        Layout l = new Layout(input);
        while(!l.next()){
        }
        System.out.println(l.noOccupied());
        Layout2 l2 = new Layout2(input);
        while(!l2.next()){

        }
        System.out.println(l2.noOccupied());
    }
}
