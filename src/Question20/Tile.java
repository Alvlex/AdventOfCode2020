package Question20;

import java.util.ArrayList;

public class Tile {
    int id;
    char[][] image;

    Tile(int id, ArrayList<String> image){
        this.id = id;
        char[][] temp = new char[image.size()][image.get(0).length()];
        for (int i = 0; i < image.size(); i ++){
            for (int j = 0; j < image.get(i).length(); j ++){
                temp[i][j] = image.get(i).charAt(j);
            }
        }
        this.image = temp;
    }

    String[] getCorner(int cornerNo){
        String[] result = new String[2];
        result[0] = getEdge(cornerNo);
        result[1] = getEdge((cornerNo + 1) % 4);
        return result;
    }

    String getEdge(int edgeNo){
        StringBuilder sb = new StringBuilder();
        if (edgeNo % 2 == 0){
            for (int i = 0; i < image[0].length; i ++){
                sb.append(image[edgeNo == 0 ? 0 : image.length - 1][i]);
            }
        }
        else{
            for (int i = 0; i < image.length; i ++){
                sb.append(image[i][edgeNo == 1 ? 0 : image[i].length - 1]);
            }
        }
        return sb.toString();
    }

    void rotateLeft(){
        char[][] result = new char[image[0].length][image.length];
        for (int i = 0; i < image.length; i ++){
            for (int j = 0; j < image[i].length; j ++){
                result[image[0].length - j][i] = image[i][j];
            }
        }
        image = result;
    }

    void flipVertical(){
        char[][] result = new char[image.length][image[0].length];
        for (int i = 0; i < image.length / 2; i ++){
            for (int j = 0; j < image[i].length; j ++){
                result[image.length - i][j] = image[i][j];
                result[i][j] = image[image.length - i][j];
            }
        }
        image = result;
    }

    boolean edgeEquals(String s1, String s2){
        return s1.equals(s2) || new StringBuilder(s1).reverse().toString().equals(s2);
    }


    boolean cornerEquals(String[] otherCorner, int cornerNo){
        String[] corner = getCorner(cornerNo);
        for (int i = 0; i < 2; i ++){
            for (int k = 0; k < corner[i].length(); k ++){
                if (otherCorner[i].charAt(k) != corner[i].charAt(k))
                    return false;
            }
        }
        return true;
    }

    void attachTile(Tile t, int edge, int tEdge){
        char[][] result;
        Tile first, second;
        if (edge % 2 == 0){
            result = new char[image.length - 2][image[0].length];
            if (edge == 2){
                first = this;
                second = t;
            }
            else{
                first = t;
                second = this;
            }
            for (int i = 0; i < result.length; i ++){
                for (int j = 0; j < result[i].length; j ++){
                    if (i < result.length / 2){
                        result[i][j] = first.image[i][j];
                    }
                    else{
                        result[i][j] = second.image[i - result.length / 2 + 1][j];
                    }
                }
            }
        }
        else{
            result = new char[image.length][2 * image[0].length - 2];
            if (edge == 3){
                first = this;
                second = t;
            }
            else{
                first = t;
                second = this;
            }
            for (int i = 0; i < result.length; i ++){
                for (int j = 0; j < result[i].length; j ++){
                    if (j < result[i].length / 2){
                        result[i][j] = first.image[i][j];
                    }
                    else{
                        result[i][j] = second.image[i][j - result[j].length / 2 + 1];
                    }
                }
            }
        }
        image = result;
    }

    boolean addTile(Tile t){
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                if (edgeEquals(getEdge(i), t.getEdge(j))){
                    if (!getEdge(i).equals(t.getEdge(j))){
                        t.flipVertical();
                        t.rotateLeft();
                        t.rotateLeft();
                    }
                    attachTile(t, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    boolean connectTiles(ArrayList<Tile> tiles){
        int i = 0;
        while(!tiles.isEmpty()) {
            if (addTile(tiles.get(i))) {
                tiles.remove(i);
                i = 0;
            } else {
                i++;
                if (i == tiles.size())
                    return false;
            }
        }
        return true;
    }
}
