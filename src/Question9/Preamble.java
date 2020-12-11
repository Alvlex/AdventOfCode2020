package Question9;

public class Preamble {

    private long[] prevNumbers = new long[25];
    private int pointer = 0;

    void add(long number){
        prevNumbers[pointer] = number;
        pointer = (pointer + 1) % prevNumbers.length;
    }

    boolean isValid(long number){
        for (int i = 0; i < prevNumbers.length; i ++)
            for (int j = i + 1; j < prevNumbers.length; j ++)
                if (prevNumbers[i] + prevNumbers[j] == number)
                    return true;
        return false;
    }

}
