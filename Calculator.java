import java.util.Scanner;

public class Calculator {
        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            double firstOperand, secondOperand, result;

            System.out.println("Enter first operand: ");
            firstOperand = scan.nextDouble();
            System.out.print("Enter second operand: ");
            secondOperand = scan.nextDouble();

            System.out.println("\nCalculator Menu");
            System.out.println("---------------");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");

            System.out.print("\nWhich operation do you want to perform? ");
            int numOperation = scan.nextInt();

            if (numOperation == 1) {
                result = firstOperand + secondOperand;
                System.out.println("\nThe result of the operation is " + result + ". Goodbye!");
            }

            if (numOperation == 2) {
                result = firstOperand - secondOperand;
                System.out.println("\nThe result of the operation is " + result + ". Goodbye!");
            }

            if (numOperation == 3) {
                result = firstOperand * secondOperand;
                System.out.println("\nThe result of the operation is " + result + ". Goodbye!");
            }

            if (numOperation == 4) {
                result = firstOperand / secondOperand;
                System.out.println("\nThe result of the operation is " + result + ". Goodbye!");
            }

            if (numOperation < 1) {
                System.out.println("\nError: Invalid selection! Terminating program."); //won't yield a result
            }

            if (numOperation > 4) {
                System.out.println("\nError: Invalid selection! Terminating program."); //won't yield a result either
            }

        }
    }
