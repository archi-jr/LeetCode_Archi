class Solution {
    /**
     * Evaluate a basic arithmetic expression containing +, -, parentheses, and spaces.
     * Time Complexity: O(n), Space Complexity: O(n) for the stack.
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        // Stack to hold previous results and signs when encountering parentheses
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;   // Current accumulated result
        int number = 0;   // Current number being parsed
        int sign = 1;     // Current sign (1 for +, -1 for -)

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // Build the current number
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                // Finalize the previous number
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                // Push the result and sign, reset for inner expression
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Complete the inner expression
                result += sign * number;
                number = 0;
                // Apply the sign before the parenthesis
                result *= stack.pop(); // pop sign
                // Add to the result before the parenthesis
                result += stack.pop(); // pop previous result
            }
            // Skip spaces and any other characters
        }
        // Add any remaining number
        result += sign * number;
        return result;
    }
}
