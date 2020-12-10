package Question6;

import java.util.HashSet;

class Group {
    private HashSet<Character> questions;

    Group(String questions){
        this.questions = new HashSet<>();
        for (char c: questions.toCharArray()){
            if (c != ' ')
                this.questions.add(c);
        }
    }

    int getNo(){
        return questions.size();
    }
}
