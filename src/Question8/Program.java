package Question8;

import java.util.ArrayList;
import java.util.HashSet;

public class Program {
    private int acc = 0;
    private ArrayList<String> lines = new ArrayList<>();

    Program(ArrayList<String> lines){
        this.lines = lines;
    }

    int runAll(){
        HashSet<Integer> instructionsRun = new HashSet<>();
        int lineNo = 0;
        while(instructionsRun.add(lineNo))
            lineNo = execute(lineNo);
        return acc;
    }

    int execute(int lineNo){
        switch(lines.get(lineNo).substring(0, 3)){
            case "jmp":
                return lineNo + Integer.parseInt(lines.get(lineNo).substring(4));
            case "acc":
                acc += Integer.parseInt(lines.get(lineNo).substring(4));
            case "nop":
                return lineNo + 1;
            default:
                throw new RuntimeException("Unhandled Instruction");
        }
    }
}
