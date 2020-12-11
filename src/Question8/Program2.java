package Question8;

import java.util.ArrayList;
import java.util.HashSet;

public class Program2 {
    private int acc = 0;
    private ArrayList<String> lines;

    Program2(ArrayList<String> lines){
        this.lines = lines;
    }

    int runAll(){
        int lineChange = -1;
        HashSet<Integer> instructionsRun = new HashSet<>();
        int lineNo;
        while(true) {
            lineNo = 0;
            lineChange ++;
            instructionsRun.clear();
            acc = 0;
            while (instructionsRun.add(lineNo)) {
                lineNo = execute(lineNo, lineChange);
                if (lineNo == lines.size())
                    return acc;
            }
        }
    }

    private int execute(int lineNo, int lineChange){
        switch(lines.get(lineNo).substring(0, 3)){
            case "jmp":
                if (lineNo == lineChange)
                    return lineNo + 1;
                return lineNo + Integer.parseInt(lines.get(lineNo).substring(4));
            case "acc":
                acc += Integer.parseInt(lines.get(lineNo).substring(4));
                return lineNo + 1;
            case "nop":
                if (lineNo == lineChange)
                    return lineNo + Integer.parseInt(lines.get(lineNo).substring(4));
                return lineNo + 1;
            default:
                throw new RuntimeException("Unhandled Instruction");
        }
    }
}
