import java.util.Scanner;

import static java.lang.Character.*;

public class Main {

    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();
        if (isValid(input)) {
            System.out.println(changeString(input));
        } else {
            System.out.println("некорректный ввод");
        }
    }


    public static String changeString(String input) throws NullPointerException {
        int multiple = 0;
        int firstBrace = 0;
        int braceCounter = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (isLetter(input.charAt(i)) && braceCounter == 0) {
                result.append(input.charAt(i));
            }
            if (isDigit(input.charAt(i)) && braceCounter == 0) {
                digits.append(input.charAt(i));
                multiple = Integer.parseInt(digits.toString());
            }
            if (input.charAt(i) == '[') {
                braceCounter++;
                if (braceCounter == 1) {
                    firstBrace = i;
                }
            }
            if (input.charAt(i) == ']') {
                braceCounter--;
                if (braceCounter == 0) {
                    result.append(changeString(input.substring(firstBrace + 1, i).repeat(multiple)));
                    digits.delete(0, digits.length() + 1);
                    multiple = 0;
                    firstBrace = 0;

                }
            }
        }

        return result.toString();
    }


    public static boolean isValid(String input) {
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if ((input.charAt(i + 1) != '[' && !Character.isDigit(input.charAt(i + 1))))
                    return false;
            }
            if (!Character.isDigit(input.charAt(i)) && !Character.isLetter(input.charAt(i)) && input.charAt(i) != '[' && input.charAt(i) != ']') {
                return false;
            }
            if (input.charAt(i) == '[') {
                leftCount++;
            }
            if (input.charAt(i) == ']') {
                rightCount++;
            }
        }

        return leftCount == rightCount;
    }

}

