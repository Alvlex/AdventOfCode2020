package Question18;

public class Expression2 {

    private String expr;

    Expression2(String e){
        expr = e;
    }

    long process(){
        return process(expr);
    }

    long process(String expr){
        long total = 0;
        for (int i = 0; i < expr.length(); i ++){
            if (expr.charAt(i) == '*'){
                return process(expr.substring(0, i).trim()) * process(expr.substring(i + 1).trim());
            }
        }
        String[] parts = expr.split(" ");
        for (int i = 0; i < parts.length; i ++ ){
            if (i % 2 == 0){
                total += Integer.parseInt(parts[i]);
            }
        }
        return total;
    }

    boolean subprocess(){
        boolean flag = false;
        StringBuilder subexpr = new StringBuilder();
        int start = 0, end = 0;
        Expression2 e = null;
        for (int i = 0; i < expr.length(); i ++){
            char c = expr.charAt(i);
            if (c == '('){
                flag = true;
                start = i;
                subexpr.delete(0, subexpr.length());
            }
            else if (c == ')'){
                e = new Expression2(subexpr.toString());
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
