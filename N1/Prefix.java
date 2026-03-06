import java.util.Stack;

public class Prefix {

    private boolean isOperator(char c) {
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    public String toInfix(String exp) {

        Stack<String> stack = new Stack<>();

        for(int i = exp.length()-1 ; i >= 0 ; i--){

            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }

            else if(isOperator(c)){

                String a = stack.pop();
                String b = stack.pop();

                String temp = "(" + a + c + b + ")";
                stack.push(temp);
            }
        }

        return stack.pop();
    }
}