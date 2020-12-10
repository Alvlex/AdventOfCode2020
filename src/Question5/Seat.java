package Question5;

public class Seat {

    private int id;

    Seat(String sequence){
        int temp = 0;
        for (int i = 0; i < sequence.length(); i ++){
            if (sequence.charAt(i) == 'B' && i < sequence.length() - 3){
                temp += Math.pow(2, sequence.length() - 4 - i);
            }
            if (i == sequence.length() - 3){
                temp *= 8;
            }
            if (i >= sequence.length() - 3 && sequence.charAt(i) == 'R'){
                temp += Math.pow(2, sequence.length() - 1 - i);
            }
        }
        id = temp;
    }

    int getID(){
        return id;
    }
}
