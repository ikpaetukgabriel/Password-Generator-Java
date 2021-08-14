import java.util.*;

public class Main {

    public static int randomFromRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }


    // Generates password
    public static String partGenerator(int charNumber, String type) {
        int start;
        int end;
        switch (type) {
            case "uppercase" :
                start = 65;
                end = 90;
                break;

            case "lowercase" :
                start = 97;
                end = 122;
                break;

            case "digit" :
                start = 48;
                end = 57;
                break;

            default:
                start = 0;
                end = 0;
                break;

        }
        if (charNumber == 0) {
            return "";
        } else {
            char[] part = new char[charNumber];
            for (int i = 0; i < charNumber; i++) {
                char tempChar = (char) randomFromRange(start, end); //a-97,z-122
                if (i != 0) {
                    while (tempChar == part[i - 1]) {
                        tempChar = (char) randomFromRange(start, end);
                    }
                }
                part[i] = tempChar;
            }
            return String.valueOf(part);
        }
    }

    public static String generator(int numUpper, int numLower, int numDigit, int numSymbols) {
        String password = "";

        String upperCase = "uppercase";
        String lowerCase = "lowercase";
        String digit = "digit";


        password += partGenerator(numUpper, upperCase);
        password += partGenerator(numLower, lowerCase);
        password += partGenerator(numDigit, digit);

        int sum = numDigit + numLower + numUpper;

        if (sum < numSymbols) {
            int mainRemainder = numSymbols - sum;
            int numUpper2 = randomFromRange(0, mainRemainder);
            int numLower2 = randomFromRange(0, mainRemainder - numUpper2);
            int numDigit2 = mainRemainder - (numUpper2 + numLower2);

            password += partGenerator(numUpper2, upperCase);
            password += partGenerator(numLower2, lowerCase);
            password += partGenerator(numDigit2, digit);
        }
        return password;
    }

    public static void main(String[] args) {
        // Main code
        Scanner scanner = new Scanner(System.in);
        int numberUppercase = scanner.nextInt();    // Number of uppercase
        int numberLowercase = scanner.nextInt();    // Number of lowercase
        int numberDigit = scanner.nextInt();        // Number of digits
        int numberSymbols = scanner.nextInt();      // Number of symbols


        System.out.println(generator(numberUppercase, numberLowercase, numberDigit, numberSymbols));
    }
}
