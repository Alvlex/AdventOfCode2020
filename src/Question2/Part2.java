package Question2;

public class Part2 {

    boolean parse(String line){
        String[] parts = line.split(":");
        String word = parts[1].substring(1);

        String[] parts2 = parts[0].split(" ");
        char target = parts2[1].charAt(0);
        String[] numbers = parts2[0].split("-");
        return validate(word, Integer.parseInt(numbers[0]) - 1, Integer.parseInt(numbers[1]) - 1, target);
    }

    boolean validate(String password, int position1, int position2, char target){
        return password.charAt(position1) == target ^ password.charAt(position2) == target;
    }
}
