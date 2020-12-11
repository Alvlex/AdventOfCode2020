package Question11;

import java.util.ArrayList;

public class Layout {
    private char[][] layout;

    Layout(ArrayList<String> input){
        layout = new char[input.size()][];
        for (int i = 0; i < input.size(); i ++){
            layout[i] = new char[input.get(i).length()];
            for (int j = 0; j < input.get(i).length(); j ++){
                layout[i][j] = input.get(i).charAt(j);
            }
        }
    }

    private String findAdjacent(int i, int j){
        StringBuilder sb = new StringBuilder();
        for (int k = Math.max(0, i - 1); k < Math.min(layout.length, i + 2); k ++){
            for (int l = Math.max(0, j - 1); l < Math.min(layout[k].length, j + 2); l ++){
                sb.append(layout[k][l]);
            }
        }
        return sb.toString();
    }

    private boolean containsN(String s, char c, int n){
        int total = 0;
        for (char sc: s.toCharArray()){
            if (sc == c)
                total ++;
        }
        return total >= n;
    }

    boolean next(){
        char[][] newLayout = new char[layout.length][layout[0].length];
        for (int i = 0; i < layout.length; i ++){
            for (int j = 0; j < layout[i].length; j ++){
                if (layout[i][j] == 'L')
                    newLayout[i][j] = findAdjacent(i,j).contains("#") ? 'L' : '#';
                else if (layout[i][j] == '.')
                    newLayout[i][j] = '.';
                else if (layout[i][j] == '#')
                    newLayout[i][j] = containsN(findAdjacent(i,j), '#', 5) ? 'L' : '#';
            }
        }
        boolean result = compareArray(layout, newLayout);
        layout = newLayout;
        return result;
    }

    private boolean compareArray(char[][] a1, char[][] a2){
        for (int i = 0; i < a1.length; i ++){
            for (int j = 0; j < a1[i].length; j ++){
                if (a1[i][j] != a2[i][j])
                    return false;
            }
        }
        return true;
    }

    int noOccupied(){
        int total = 0;
        for (int i = 0; i < layout.length; i ++){
            for (int j = 0; j < layout[i].length; j ++){
                total = layout[i][j] == '#' ? total + 1 : total;
            }
        }
        return total;
    }
}
