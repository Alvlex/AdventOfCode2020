package Question2;

public class Part1 {

    boolean parse(String line){
        String[] parts = line.split(":");
        String word = parts[1].substring(1);

        String[] parts2 = parts[0].split(" ");
        char target = parts2[1].charAt(0);
        String[] numbers = parts2[0].split("-");
        return validate(word, Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), target);
    }



    boolean validate(String password, int min, int max, char target){
        int occurence = 0;
        for (char c: password.toCharArray()){
            if (c == target){
                occurence ++;
            }
        }
        return min <= occurence && occurence <= max;
    }

}
