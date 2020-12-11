package Question11;

import java.util.ArrayList;

public class Layout2 {
    private char[][] layout;

    Layout2(ArrayList<String> input){
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
        for (int k = 0; k < 4; k ++){
            int temp = (k / 2) == 0 ? 1 : -1;
            if (k % 2 == 0){
                try {
                    while (layout[i + temp][j] == '.') {
                        temp = k == 0 ? temp + 1 : temp - 1;
                    }
                    sb.append(layout[i + temp][j]);
                }
                catch(ArrayIndexOutOfBoundsException e){
                    sb.append('.');
                }
            }
            else{
                try {
                    while (layout[i][j + temp] == '.') {
                        temp = k == 1 ? temp + 1 : temp - 1;
                    }
                    sb.append(layout[i][j + temp]);
                }
                catch(ArrayIndexOutOfBoundsException e){
                    sb.append('.');
                }

            }
        }
        for (int k = 0; k < 4; k ++){
            int temp1 = (k % 2) * 2 - 1;
            int temp2 = k / 2 == 0 ? -1 + k * 2 : 1 - (k - 2) * 2;
            int distance = 1;
            try {
                while (layout[i + temp1 * distance][j + temp2 * distance] == '.') {
                    distance++;
                }
                sb.append(layout[i + temp1 * distance][j + temp2 * distance]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                sb.append('.');
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
