package Question16;

import common.Input;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        ArrayList<String> input = Input.getInput("Q16.txt");
        Rules rules = new Rules();
        int ruleNo = 0;
        Tickets tickets = new Tickets();
        Ticket myTicket = null;
        boolean inNearbyTickets = false;
        boolean inMyTicket = false;
        int total = 0;
        for (String s: input){
            ruleNo ++;
            if (s.length() > 0 && !Character.isDigit(s.charAt(0)) && !s.contains("ticket")){
                String[] parts = s.split(":");
                String[] ranges = parts[1].split("or");
                String[] range1 = ranges[0].split("-");
                String[] range2 = ranges[1].split("-");
                rules.addRule(new Rule(ruleNo, Integer.parseInt(range1[0].trim()), Integer.parseInt(range2[0].trim()), Integer.parseInt(range1[1].trim()), Integer.parseInt(range2[1].trim())));
            }
            else if (s.contains("your ticket")){
                inMyTicket = true;
            }
            else if (s.contains("nearby tickets")) {
                inNearbyTickets = true;
                inMyTicket = false;
            }
            else if (inMyTicket && s.length() > 0){
                myTicket = new Ticket(s);
            }
            else if (inNearbyTickets && s.length() > 0){
                int noErrors = rules.getErrors(s);
                if (noErrors == -1)
                    tickets.addTicket(new Ticket(s));
                else
                    total += noErrors;
            }
        }
        System.out.println(total);
        System.out.println(tickets.getAnswer(myTicket, rules));
    }
}
