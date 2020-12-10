package Question5;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> seats = Input.getInput("Q5.txt");
        ArrayList<Seat> parsed = new ArrayList<>();
        int highest = 0;
        for (String seat: seats){
            Seat s = new Seat(seat);
            parsed.add(s);
            if (s.getID() > highest){
                highest = s.getID();
            }
        }
        System.out.println(highest);
        boolean[] seatExists = new boolean[highest + 1];
        for (Seat s: parsed){
            seatExists[s.getID()] = true;
        }
        for (int i = 0; i < highest + 1; i ++)
            if (i > 1 && i < highest)
                if (seatExists[i - 1] && !seatExists[i] && seatExists[i + 1])
                    System.out.println(i);
    }
}
