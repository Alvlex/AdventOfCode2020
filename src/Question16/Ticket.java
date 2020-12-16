package Question16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ticket {
    private ArrayList<Integer> fields;

    Ticket(String line){
        fields = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    int getField(int pos){
        return fields.get(pos);
    }

    int getNoFields(){
        return fields.size();
    }
}
