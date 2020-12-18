package Question17;

import java.util.ArrayList;
import java.util.HashMap;

public class Simulation {

    HashMap<Integer, ArrayList<Coordinates>> space = new HashMap<>();

    Simulation(ArrayList<String> start) {
        ArrayList<Coordinates> first = new ArrayList<>();
        for (int i = 0; i < start.size(); i ++){
            for (int j = 0; j < start.get(i).length(); j ++){
                if (start.get(i).charAt(j) == '#')
                    first.add(new Coordinates(i,j));
            }
        }
        space.put(0, first);
    }

    boolean contains(ArrayList<Coordinates> array, Coordinates c){
        for (Coordinates coord: array){
            if (c.equals(coord))
                return true;
        }
        return false;
    }

    int checkNeighbours(int z, Coordinates xy){
        int result = 0;
        for (int i = z - 1; i <= z + 1; i ++){
            for (int j = xy.x - 1; j <= xy.x + 1; j ++){
                for (int k = xy.y - 1; k <= xy.y + 1; k ++){
                    if (i != z || j != xy.x || k != xy.y)
                        result = space.get(i) != null && contains(space.get(i), new Coordinates(j,k)) ? result + 1 : result;
                }
            }
        }
        return result;
    }

    HashMap<Integer, ArrayList<Coordinates>> findNeighbours(int z, Coordinates xy){
        HashMap<Integer, ArrayList<Coordinates>> result = new HashMap<>();
        for (int i = z - 1; i <= z + 1; i ++){
            ArrayList<Coordinates> temp = new ArrayList<>();
            for (int j = xy.x - 1; j <= xy.x + 1; j ++){
                for (int k = xy.y - 1; k <= xy.y + 1; k ++){
                    temp.add(new Coordinates(j,k));
                }
            }
            result.put(i, temp);
        }
        return result;
    }

    boolean isAlive(int z, Coordinates c){
        return space.get(z) != null && contains(space.get(z), c);
    }

    boolean isAliveNext(boolean active, int noNeighbours){
        return noNeighbours == 3 || (active && noNeighbours == 2);
    }

    void run(){
        HashMap<Integer, ArrayList<Coordinates>> nextStep = new HashMap<>();
        HashMap<Integer, ArrayList<Coordinates>> toCheck = new HashMap<>();

        for (int z: space.keySet()){
            for (Coordinates c: space.get(z)){
                HashMap<Integer, ArrayList<Coordinates>> temp = findNeighbours(z, c);
                for (int z1: temp.keySet()){
                    for (Coordinates c1: temp.get(z1)){
                        if (toCheck.get(z1) != null && !contains(toCheck.get(z1), c1)) {
                            toCheck.get(z1).add(c1);
                        }
                        else if (toCheck.get(z1) == null) {
                            ArrayList<Coordinates> temp2 = new ArrayList<>();
                            temp2.add(c1);
                            toCheck.put(z1, temp2);
                        }
                    }
                }
            }
        }

        for (int z: toCheck.keySet()){
            for (Coordinates c: toCheck.get(z)){
                if (isAliveNext(isAlive(z, c), checkNeighbours(z, c))){
                    nextStep.computeIfAbsent(z, k -> new ArrayList<>());
                    nextStep.get(z).add(c);
                }
            }
        }

        space = nextStep;
    }

    int count(){
        int total = 0;
        for (ArrayList<Coordinates> plane: space.values()){
            total += plane.size();
        }
        return total;
    }

    void print(){
        for (int z: space.keySet()){
            System.out.println("z = " + z);
            System.out.println("    " + space.get(z).size());
//            for (Coordinates xy: space.get(z)){
//                System.out.println("    x: " + xy.x + ", y: " + xy.y);
//            }
        }
    }
}
