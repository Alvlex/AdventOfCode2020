package Question17;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q17.txt");
        Simulation s = new Simulation(input);
        Simulation4D s4 = new Simulation4D(input);
        for (int i = 0; i < 6; i ++){
            s.run();
            s4.run();

        }
        System.out.println(s.count());
        System.out.println(s4.count());
    }
}
