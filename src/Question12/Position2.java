package Question12;

class Position2 {
    private int horizontal = 0;
    private int vertical = 0;
    private int waypointH = 10;
    private int waypointV = -1;

    void turnRight(int degrees){
        int temp = waypointV;
        switch(degrees){
            case 90:
                waypointV = waypointH;
                waypointH = - temp;
                break;
            case 180:
                waypointV = - waypointV;
                waypointH = - waypointH;
                break;
            case 270:
                waypointV = - waypointH;
                waypointH = temp;
                break;
        }
    }

    void turnLeft(int degrees){
        turnRight(360 - degrees);
    }

    void forward(int steps){
        horizontal += steps * waypointH;
        vertical += steps * waypointV;
    }

    void north(int steps){
        waypointV -= steps;
    }

    void east(int steps){
        waypointH += steps;
    }

    void south(int steps){
        waypointV += steps;
    }

    void west(int steps){
        waypointH -= steps;
    }

    int getDistance(){
        return Math.abs(horizontal) + Math.abs(vertical);
    }

}
