package Question17;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation4D {

    HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> space = new HashMap<>();

    Simulation4D(ArrayList<String> start) {
        HashMap<Integer, ArrayList<Coordinates>> temp = new HashMap<>();
        ArrayList<Coordinates> first = new ArrayList<>();
        for (int i = 0; i < start.size(); i ++){
            for (int j = 0; j < start.get(i).length(); j ++){
                if (start.get(i).charAt(j) == '#')
                    first.add(new Coordinates(i,j));
            }
        }
        temp.put(0, first);
        space.put(0, temp);
    }

    boolean contains(ArrayList<Coordinates> array, Coordinates c){
        for (Coordinates coord: array){
            if (c.equals(coord))
                return true;
        }
        return false;
    }

    int checkNeighbours(int z, int w, Coordinates xy){
        int result = 0;
        for (int h = w - 1; h <= w + 1; h ++) {
            for (int i = z - 1; i <= z + 1; i++) {
                for (int j = xy.x - 1; j <= xy.x + 1; j++) {
                    for (int k = xy.y - 1; k <= xy.y + 1; k++) {
                        if (i != z || j != xy.x || k != xy.y || h != w)
                            result = space.get(h) != null && space.get(h).get(i) != null && contains(space.get(h).get(i), new Coordinates(j, k)) ? result + 1 : result;
                    }
                }
            }
        }
        return result;
    }

    HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> findNeighbours(int z, int w, Coordinates xy){
        HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> result = new HashMap<>();
        for (int h = w - 1; h <= w + 1; h ++) {
            HashMap<Integer, ArrayList<Coordinates>> temp2 = new HashMap<>();
            for (int i = z - 1; i <= z + 1; i++) {
                ArrayList<Coordinates> temp = new ArrayList<>();
                for (int j = xy.x - 1; j <= xy.x + 1; j++) {
                    for (int k = xy.y - 1; k <= xy.y + 1; k++) {
                        temp.add(new Coordinates(j, k));
                    }
                }
                temp2.put(i, temp);
            }
            result.put(h, temp2);
        }
        return result;
    }

    boolean isAlive(int z, int w, Coordinates c){
        return space.get(w) != null  && space.get(w).get(z) != null && contains(space.get(w).get(z), c);
    }

    boolean isAliveNext(boolean active, int noNeighbours){
        return noNeighbours == 3 || (active && noNeighbours == 2);
    }

    void run(){
        HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> nextStep = new HashMap<>();
        HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> toCheck = new HashMap<>();

        for (int w: space.keySet()) {
            for (int z : space.get(w).keySet()) {
                for (Coordinates c : space.get(w).get(z)) {
                    HashMap<Integer, HashMap<Integer, ArrayList<Coordinates>>> temp = findNeighbours(z, w, c);
                    for (int w1 : temp.keySet()) {
                        for (int z1 : temp.get(w1).keySet()) {
                            for (Coordinates c1 : temp.get(w1).get(z1)) {
                                if (toCheck.get(w1) != null && toCheck.get(w1).get(z1) != null && (!contains(toCheck.get(w1).get(z1), c1))) {
                                    toCheck.get(w1).get(z1).add(c1);
                                } else if (toCheck.get(w1) == null) {
                                    ArrayList<Coordinates> temp2 = new ArrayList<>();
                                    temp2.add(c1);
                                    HashMap<Integer, ArrayList<Coordinates>> temp3 = new HashMap<>();
                                    temp3.put(z1, temp2);
                                    toCheck.put(w1, temp3);
                                }
                                else if (toCheck.get(w1).get(z1) == null){
                                    ArrayList<Coordinates> temp2 = new ArrayList<>();
                                    temp2.add(c1);
                                    toCheck.get(w1).put(z1, temp2);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int w: toCheck.keySet()) {
            for (int z : toCheck.get(w).keySet()) {
                for (Coordinates c : toCheck.get(w).get(z)) {
                    if (isAliveNext(isAlive(z, w, c), checkNeighbours(z, w, c))) {
                        nextStep.computeIfAbsent(w, k -> new HashMap<>());
                        nextStep.get(w).computeIfAbsent(z, k -> new ArrayList<>());
                        nextStep.get(w).get(z).add(c);
                    }
                }
            }
        }

        space = nextStep;
    }

    int count(){
        int total = 0;
        for (int w: space.keySet()){
            for (int z: space.get(w).keySet()){
                total += space.get(w).get(z).size();
            }
        }
        return total;
    }

    void print(){
        for (int w: space.keySet()){
            for (int z: space.get(w).keySet()) {
                System.out.println("wz = " + w + ", " + z);
                System.out.println("    " + space.get(w).get(z).size());
            }
        }
    }
}
