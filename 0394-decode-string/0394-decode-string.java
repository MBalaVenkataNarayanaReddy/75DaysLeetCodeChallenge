import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                currentNumber = currentNumber * 10 + (ch - '0');

            } else if (ch == '[') {

                numberStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder();

            } else if (ch == ']') {

                int repeatTimes = numberStack.pop();
                StringBuilder previousString = stringStack.pop();

                for (int i = 0; i < repeatTimes; i++) {
                    previousString.append(currentString);
                }

                currentString = previousString;

            } else {

                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}