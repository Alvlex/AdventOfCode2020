package Question12;

class Position {
    private int horizontal = 0;
    private int vertical = 0;
    private int direction = 1;

    void turnRight(int degrees){
        direction = (direction + degrees / 90) % 4;
    }

    void turnLeft(int degrees){
        direction = (direction + 3 * degrees / 90) % 4;
    }

    void forward(int steps){
        if (direction % 2 == 0){
            vertical = direction == 0 ? vertical - steps : vertical + steps;
        }
        else{
            horizontal = direction == 1 ? horizontal + steps : horizontal - steps;
        }
    }

    void north(int steps){
        vertical -= steps;
    }

    void east(int steps){
        horizontal += steps;
    }

    void south(int steps){
        vertical += steps;
    }

    void west(int steps){
        horizontal -= steps;
    }

    int getDistance(){
        return Math.abs(horizontal) + Math.abs(vertical);
    }

}
