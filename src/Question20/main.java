package Question20;

import common.Input;

import java.util.ArrayList;
import java.util.HashSet;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q20.txt");
        ArrayList<Tile> tiles = new ArrayList<>();
        int tempId = 0;
        ArrayList<String> image = new ArrayList<>();
        for (String s: input){
            if (s.contains("Tile")){
                tempId = Integer.parseInt(s.substring(0, s.length() - 1).split(" ")[1]);
            }
            else if (s.length() == 0){
                tiles.add(new Tile(tempId, image));
                image.clear();
            }
            else{
                image.add(s);
            }
        }

        HashSet<Tile> cornerTiles = new HashSet<>();

        for (Tile t: tiles){
            int total = 0;
            for (Tile t2: tiles){
                if (t.id != t2.id) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (t.edgeEquals(t.getEdge(i), t2.getEdge(j))) {
                                total++;
                            }
                        }
                    }
                }
            }
            if (total == 2){
                cornerTiles.add(t);
            }
        }
        long total = 1;
        for (Tile t: cornerTiles){
            total *= t.id;
        }
        System.out.println(total);

        // Part2
        Tile bigTile = tiles.remove(0);
        System.out.println(bigTile.connectTiles(tiles));

    }
}
