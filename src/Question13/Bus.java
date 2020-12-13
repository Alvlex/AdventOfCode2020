package Question13;

public class Bus {

    private int id;

    Bus(int id){
        this.id = id;
    }

    long getNextTrip(long x){
        long temp = 0;
        while((x + temp) % id != 0){
            temp ++;
        }
        return x + temp;
    }

    int getId(){
        return id;
    }
}
