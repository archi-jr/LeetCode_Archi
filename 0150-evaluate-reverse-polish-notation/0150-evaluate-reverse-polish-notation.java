class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) 
        {
            if (isOperator(token)) 
            {
                int b = stack.pop();//2nd element
                int a = stack.pop();//1st element
                stack.push(calculate(a, b, token));
            } 
            else 
            {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.peek();
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    private int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}