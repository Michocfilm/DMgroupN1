import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== Expression Converter ====");
        System.out.println("1. Convert to Infix");
        System.out.println("2. Infix -> Postfix");
        System.out.println("3. Infix -> Prefix");

        System.out.print("Select: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                Infix infix = new Infix();
                infix.convertToInfix(); // ไปจัดการเมนูย่อยใน class Infix
                break;

            case 2:
                System.out.print("Enter Infix Expression: ");
                String exp1 = sc.nextLine();

                Infix i1 = new Infix();
                System.out.println("Postfix: " + i1.toPostfix(exp1));
                break;

            case 3:
                System.out.print("Enter Infix Expression: ");
                String exp2 = sc.nextLine();

                Infix i2 = new Infix();
                System.out.println("Prefix: " + i2.toPrefix(exp2));
                break;

            case 4:
                System.out.print("Enter Postfix Expression: ");
                String exp3 = sc.nextLine();

                Postfix p = new Postfix();
                p.showStackProcess(exp3);
                break;
                
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}