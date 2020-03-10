import java.util.Scanner;
import java.lang.Math;

// This is a new comment
public class SciCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstOperand, secondOperand;
        double result = 0.0;
        double sum = 0.0;
        int count = 0;
        int numOperation = 7;

        // This condition avoids printing menu when numOperation < 0
        while (numOperation > 0) {
            // Print the menu
            System.out.println("\nCurrent Result: " + result);
            System.out.println("\nCalculator Menu");
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average");

            while (true) {
                System.out.print("\nEnter Menu Selection: ");
                numOperation = scan.nextInt();

                // If the user types 1-6
                if (numOperation > 0 && numOperation < 7) {
                    System.out.print("Enter first operand: ");
                    firstOperand = scan.nextDouble();
                    System.out.print("Enter second operand: ");
                    secondOperand = scan.nextDouble();

                    if (numOperation == 1) {
                        result = firstOperand + secondOperand;
                        ++count;
                    }
                    else if (numOperation == 2) {
                        result = firstOperand - secondOperand;
                        ++count;
                    }
                    else if (numOperation == 3) {
                        result = firstOperand * secondOperand;
                        ++count;
                    }
                    else if (numOperation == 4) {
                        result = firstOperand / secondOperand;
                        ++count;
                    }
                    else if (numOperation == 5) {
                        result = Math.pow(firstOperand, secondOperand);
                        ++count;
                    }
                    else if (numOperation == 6) {
                        result = Math.log(secondOperand) / Math.log(firstOperand);
                        ++count;
                    }
                    sum = sum + result;
                    break; // Jump out of the second while loop once the calculation is done
                }

                // If the user types 7
                else if (numOperation == 7) {
                    if (result == 0.0) {
                        System.out.println("\nError: No calculations yet to average! ");
                    }
                    else {
                        System.out.println("\nSum of calculations: " + sum);
                        System.out.println("Number of calculations: " + count);
                        double average = Math.round((sum / count) * 100 ) / 100.0;
                        System.out.println("Average of calculations: " + average);
                    }
                }

                // If the user types 0
                else if (numOperation == 0) {
                    System.out.println("\nThanks for using this calculator. Goodbye! ");
                    break; //terminate the whole program
                }

                // If the user types any other number
                else {
                    System.out.println("\nError: Invalid selection! ");
                }
            }
        }
    }
}
