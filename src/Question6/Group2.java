package Question6;

import java.util.HashSet;

class Group2 {
    private HashSet<Character> questions;

    Group2(String questions){
        this.questions = new HashSet<>();
        String[] people = questions.split(" ");
        HashSet<Character> person1 = new HashSet<>();
        for (char c: people[0].toCharArray()){
            person1.add(c);
        }
        HashSet<Character> acc = person1;
        for (int i = 1; i < people.length; i ++){
            HashSet<Character> personi = new HashSet<>();
            for (char c: people[i].toCharArray()){
                personi.add(c);
            }
            HashSet<Character> temp = new HashSet<>();
            for (char c: acc){
                if (personi.contains(c)){
                    temp.add(c);
                }
            }
            acc = temp;
        }
        this.questions = acc;
    }

    int getNo(){
        return questions.size();
    }
}
