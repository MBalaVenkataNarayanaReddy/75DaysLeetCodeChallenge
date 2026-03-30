import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char currentChar : s.toCharArray()) {

            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((currentChar == ')' && top != '(') ||
                    (currentChar == '}' && top != '{') ||
                    (currentChar == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}