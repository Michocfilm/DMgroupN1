import java.util.Stack;

public class Postfix {

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public String toInfix(String exp) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            }

            else if (isOperator(c)) {

                String b = stack.pop();
                String a = stack.pop();

                String temp = "(" + a + c + b + ")";
                stack.push(temp);
            }
        }

        return stack.pop();
    }

    public void showStackProcess(String exp) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {

                stack.push(c + "");
                System.out.println("Push " + c);

            }

            else {

                String b = stack.pop();
                String a = stack.pop();

                System.out.println("Pop " + a + " , " + b);
                System.out.println("ALU: " + a + " " + c + " " + b);

                String result = "(" + a + c + b + ")";

                stack.push(result);

                System.out.println("Push result: " + result);
            }
        }

        System.out.println("Final Result: " + stack.pop());
    }
}