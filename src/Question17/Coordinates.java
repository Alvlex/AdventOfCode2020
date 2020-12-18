package Question17;

public class Coordinates {
    public int x, y;

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        return ((Coordinates) other).x == x && ((Coordinates) other).y == y;
    }
}
