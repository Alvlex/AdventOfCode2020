package Question18;

public class Expression {

    private String expr;

    Expression(String e){
        expr = e;
    }

    long process(){
        long total = 0;
        String[] parts = expr.split(" ");
        char operation = '+';
        for (int i = 0; i < parts.length; i ++){
            if (i % 2 == 0){
                if (operation == '+')
                    total += Integer.parseInt(parts[i]);
                else
                    total *= Integer.parseInt(parts[i]);
            }
            else
                operation = parts[i].charAt(0);
        }
        return total;
    }

    boolean subprocess(){
        boolean flag = false;
        StringBuilder subexpr = new StringBuilder();
        int start = 0, end = 0;
        Expression e = null;
        for (int i = 0; i < expr.length(); i ++){
            char c = expr.charAt(i);
            if (c == '('){
                flag = true;
                start = i;
                subexpr.delete(0, subexpr.length());
            }
            else if (c == ')'){
                e = new Expression(subexpr.toString());
                end = i;
                break;
            }
            else{
                subexpr.append(c);
            }
        }
        if (flag)
            expr = String.format("%s%d%s", expr.substring(0, start), e.process(), expr.substring(end + 1));
        return flag;
    }
}
