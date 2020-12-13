package Question13;

import common.Input;

import java.util.ArrayList;
import java.util.Date;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q13.txt");
        int myTime = Integer.parseInt(input.get(0));
        String[] ids = input.get(1).split(",");
        ArrayList<Bus> buses = new ArrayList<>();
        for (String id: ids){
            if (!id.equals("x")){
                buses.add(new Bus(Integer.parseInt(id)));
            }
        }
        long[] nextTrips = new long[buses.size()];
        for (int i = 0; i < buses.size(); i ++){
            nextTrips[i] = buses.get(i).getNextTrip(myTime);
        }
        long min = Long.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < nextTrips.length; i ++){
            if (nextTrips[i] < min){
                min = nextTrips[i];
                index = i;
            }
        }
        long result = (min - myTime) * buses.get(index).getId();
        System.out.println(result);

        // Part 2
        Date d = new Date();
        int[] array = new int[input.get(1).split(",").length];
        for (int i = 0; i < array.length; i ++){
            try {
                array[i] = Integer.parseInt(input.get(1).split(",")[i]);
            }
            catch(Exception e){
                array[i] = 0;
            }
        }

        long t = array[0];
        while(valid(t, array) != array.length){
            long temp = 1;
            for (int i = 0; i < valid(t, array); i ++){
                if (array[i] != 0)
                    temp *= array[i];
            }
            t += temp;
        }
        System.out.println(t);
        System.out.println(new Date().getTime() - d.getTime());
    }

    private static int valid(long t, int[] series){
        for (int i = 0; i < series.length; i ++){
            if (series[i] != 0){
                if ((t + i) % series[i] != 0)
                    return i;
            }
        }
        return series.length;
    }
}
