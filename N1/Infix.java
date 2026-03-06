import java.util.Scanner;
import java.util.Stack;

public class Infix {

    Scanner sc = new Scanner(System.in);

    public void convertToInfix() {

        System.out.println("Convert to Infix from:");
        System.out.println("1. Prefix");
        System.out.println("2. Postfix");

        System.out.print("Select: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Expression: ");
        String exp = sc.nextLine();

        switch (choice) {

            case 1:
                Prefix p = new Prefix();
                System.out.println("Infix: " + p.toInfix(exp));
                break;

            case 2:
                Postfix pf = new Postfix();
                System.out.println("Infix: " + pf.toInfix(exp));
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    // ===== infix -> postfix =====
    private boolean isOperator(char c) {
        return c=='+' || c=='-' || c=='*' || c=='/';
    }

    private int precedence(char c) {

        switch(c){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
        }

        return -1;
    }

    public String toPostfix(String exp){

        Stack<Character> stack = new Stack<>();
        String result = "";

        for(int i=0;i<exp.length();i++){

            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result += c;
            }

            else if(c=='('){
                stack.push(c);
            }

            else if(c==')'){

                while(!stack.isEmpty() && stack.peek()!='('){
                    result += stack.pop();
                }

                stack.pop();
            }

            else if(isOperator(c)){

                while(!stack.isEmpty() &&
                        precedence(c) <= precedence(stack.peek())){

                    result += stack.pop();
                }

                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }

    public String toPrefix(String exp){

        StringBuilder input = new StringBuilder(exp);
        input.reverse();

        for(int i=0;i<input.length();i++){

            if(input.charAt(i)=='(')
                input.setCharAt(i, ')');

            else if(input.charAt(i)==')')
                input.setCharAt(i, '(');
        }

        String postfix = toPostfix(input.toString());

        return new StringBuilder(postfix).reverse().toString();
    }
}