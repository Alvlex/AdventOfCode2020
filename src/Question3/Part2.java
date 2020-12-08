package Question3;

import java.util.ArrayList;

public class Part2 {

    int path(ArrayList<String> lines, int gradient, int orientation){
        int position = 0;
        int hits = 0;
        if (orientation == 1) {
            for (String line : lines) {
                hits = hitTree(line, position) ? hits + 1 : hits;
                position += gradient;
                position = position % line.length();
            }
        }
        else{
            for (int i = 0; i < lines.size(); i += gradient){
                hits = hitTree(lines.get(i), position) ? hits + 1 : hits;
                position += 1;
                position = position % lines.get(i).length();
            }
        }
        return hits;
    }

    boolean hitTree(String line, int position){
        return line.charAt(position) == '#';
    }
}
