package Question12;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q12.txt");
        Position p = new Position();
        Position2 p2 = new Position2();
        for(String s: input){
            int num = Integer.parseInt(s.substring(1));
            switch(s.charAt(0)){
                case 'N':
                    p.north(num);
                    p2.north(num);
                    break;
                case 'E':
                    p.east(num);
                    p2.east(num);
                    break;
                case 'S':
                    p.south(num);
                    p2.south(num);
                    break;
                case 'W':
                    p.west(num);
                    p2.west(num);
                    break;
                case 'R':
                    p.turnRight(num);
                    p2.turnRight(num);
                    break;
                case 'L':
                    p.turnLeft(num);
                    p2.turnLeft(num);
                    break;
                case 'F':
                    p.forward(num);
                    p2.forward(num);
                    break;
            }
        }
        System.out.println(p.getDistance());
        System.out.println(p2.getDistance());
    }
}
