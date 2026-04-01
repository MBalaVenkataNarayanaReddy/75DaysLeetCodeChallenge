import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {

                int secondNumber = stack.pop();
                int firstNumber = stack.pop();

                if (token.equals("+")) {
                    stack.push(firstNumber + secondNumber);
                } else if (token.equals("-")) {
                    stack.push(firstNumber - secondNumber);
                } else if (token.equals("*")) {
                    stack.push(firstNumber * secondNumber);
                } else {
                    stack.push(firstNumber / secondNumber);
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}