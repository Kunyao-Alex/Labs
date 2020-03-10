// Line 89 - 96 cited from Muhammed Refaat on https://stackoverflow.com/questions/13465098
import java.util.Scanner;

public class NumericConversion {
    public static long hexStringDecode(String hex) {
        hex = hex.toUpperCase(); // Convert the string to all uppercase letters
        long result1 = 0;
        int index = 0;

        // Take off "0x" when analyzing String hex
        if (hex.substring(0, 2) == "0x") {
            hex = hex.substring(2, hex.length() - 1);
        }

        while (index <= hex.length() - 1) {
            char digit = hex.charAt(index);
            short result2 = hexCharDecode(digit); // Identify the single digit by the method hexCharDecode
            result1 = 16 * result1 + result2;
            ++index;
        }
        return result1;
    }

    public static short hexCharDecode(char digit) {
        short result2 = 0;

        // If digit is from '0' - '9'
        // Return its short value
        if (digit >= '0' && digit <= '9') {
            result2 = (short)(digit - '0');
        }

        // Else if digit is from 'A' / 'a' - 'F' / 'f'
        // Return its designated value in hexadecimal system
        else if (digit == 'A' || digit == 'a') {
            result2 = 10;
        }

        else if (digit == 'B' || digit == 'b') {
            result2 = 11;
        }

        else if (digit == 'C' || digit == 'c') {
            result2 = 12;
        }

        else if (digit == 'D' || digit == 'd') {
            result2 = 13;
        }

        else if (digit == 'E' || digit == 'e') {
            result2 = 14;
        }
        
        else if (digit == 'F' || digit == 'f') {
            result2 = 15;
        }
        return result2;
    }

    public static short binaryStringDecode(String binary) {
        short result3 = 0;
        int index = 0;

        // Take off "0b" when analyzing String binary
        if (binary.substring(0, 2) == "0b") {
            binary = binary.substring(2, binary.length() - 1);
        }

        while (index <= binary.length() - 1) {
            // If the char at index is '1'
            // Add the value to the result
            if (binary.charAt(index) == '1') {
                // (binary.length() - 1 - index) gets the index of char that is '1' from right to left
                result3 = (short) (result3 + Math.pow(2, binary.length() - 1 - index));
            }
            ++index;
        }
        return result3;
    }

    public static String binaryToHex(String binary2) {
        short decimal = binaryStringDecode(binary2); // Convert the binary2 to a decimal value
        String result4 = "";

        // Cited from Muhammed Refaat on https://stackoverflow.com/questions/13465098
        // Store different char of digits in a char array
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        // Loop stops when decimal == 0
        while (decimal != 0) {
            int rem = decimal % 16; // Get the remainder of decimal
            result4 = digits[rem] + result4; // add the char of remainder to result4
            decimal /= 16; // Get the remaining decimal
        }
        return result4;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String userInput;

        while (true) {
            // Print the menu after an execution is ended
            // Not if option == 4
            System.out.println("\nDecoding Menu");
            System.out.println("------------- ");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.print("\nPlease enter an option: ");
            option = sc.nextInt();

            // Decode a hexadecimal value
            if (option == 1) {
                System.out.print("Please enter the numeric string to convert: ");
                userInput = sc.next();
                long result1 = hexStringDecode(userInput);
                System.out.println("\nResult: " + result1);
            }

            // Decode a binary value
            else if (option == 2) {
                System.out.print("Please enter the numeric string to convert: ");
                userInput = sc.next();
                short result2 = binaryStringDecode(userInput);
                System.out.println("Result: " + result2);

            }

            // Convert a binary value to a hexadecimal value
            else if (option == 3) {
                System.out.print("Please enter the numeric string to convert: ");
                userInput = sc.next();
                String result3 = binaryToHex(userInput);
                System.out.println("Result: " + result3);

            }

            // Get out of the loop and terminate the program
            else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}