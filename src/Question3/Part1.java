package Question3;

import java.util.ArrayList;

public class Part1 {


    int path(ArrayList<String> lines, int gradient){
        int position = 0;
        int hits = 0;
        for (String line: lines){
            hits = hitTree(line, position) ? hits + 1 : hits;
            position += gradient;
        }
        return hits;
    }

    boolean hitTree(String line, int position){
        position = position % line.length();
        return line.charAt(position) == '#';
    }
}
