class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the result and sign onto stack
                stack.push(result);
                stack.push(sign);
                // Reset for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                // Pop the sign and previous result
                result *= stack.pop();    // multiply by sign before '('
                result += stack.pop();    // add the previous result
            }
            // Skip spaces automatically
        }
        
        return result + (sign * number);
    }
}