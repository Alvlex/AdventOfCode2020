package Question16;

import java.util.ArrayList;
import java.util.HashSet;

public class Tickets {
    private ArrayList<Ticket> validTickets = new ArrayList<>();

    void addTicket(Ticket t){
        validTickets.add(t);
    }

    private ArrayList<HashSet<Integer>> copy(ArrayList<HashSet<Integer>> h){
        ArrayList<HashSet<Integer>> copy = new ArrayList<>();
        for (HashSet<Integer> hash: h){
            HashSet<Integer> hcop = new HashSet<>(hash);
            copy.add(hcop);
        }
        return copy;
    }

    private Rule[] generateAllPossibilities(Rules r){
        ArrayList<HashSet<Integer>> temp = new ArrayList<>();
        for (int pos = 0; pos < 20; pos ++) {
            HashSet<Integer> temp2 = new HashSet<>();
            for (int i = 0; i < 20; i++) {
                boolean add = true;
                for (Ticket t : validTickets) {
                    if (!r.getRule(i + 1).inRange(t.getField(pos))) {
                        add = false;
                        break;
                    }
                }
                if (add)
                    temp2.add(i + 1);
            }
            temp.add(temp2);
        }
        ArrayList<HashSet<Integer>> temp10 = copy(temp);
        while(true){
            int toRemove = 0;
            for (HashSet<Integer> h: temp){
                if (h.size() == 1){
                    for (int n: h){
                        toRemove = n;
                    }
                }
            }

            if (toRemove == 0)
                break;
            else{
                for (int i = 0; i < temp.size(); i ++){
                    removeElement(toRemove, temp.get(i), 0);
                    removeElement(toRemove, temp10.get(i), 1);
                }
            }
        }

        Rule[] ru = new Rule[20];
        for (int i = 0; i < 20; i ++){
            for (int n: temp10.get(i)){
                ru[i] = r.getRule(n);
            }
        }
        return ru;
    }

    private void removeElement(int n, HashSet<Integer> h, int no){
        if (h.size() > no)
            h.remove(n);
    }

    long getAnswer(Ticket t, Rules r){
        Rule[] orderedRules = generateAllPossibilities(r);
        long total = 1;
        for (int i = 0; i < orderedRules.length; i++){
            if (orderedRules[i].descriptionIncludes(6) ||
                    orderedRules[i].descriptionIncludes(1) ||
                    orderedRules[i].descriptionIncludes(2) ||
                    orderedRules[i].descriptionIncludes(3) ||
                    orderedRules[i].descriptionIncludes(4) ||
                    orderedRules[i].descriptionIncludes(5)) {
                total *= t.getField(i);
            }
        }
        return total;
    }

}
