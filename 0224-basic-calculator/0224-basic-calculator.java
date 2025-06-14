//Whenever, in Question it is said that "Calculator" we have to use Stack. 
//TC = O(N), where, N -> is the length of the input string

class Solution {
    public int calculate(String s) {
        int len = s.length();
        int sign = +1; //Here, for sign variable +1 means +ve sign and -1 means -ve sign
        int ans = 0;
        int currNo = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<len; i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                currNo = s.charAt(i) - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i+1)))
                {
                    currNo = currNo * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                currNo = currNo * sign;
                ans += currNo;
                currNo = 0;//Thses 2 variables(currNo and sign) are again set back to the default value
                sign = 1;
            }
            else if(s.charAt(i) == '+')
            sign = +1;

            else if(s.charAt(i) == '-')
            sign = -1;

            else if(s.charAt(i) == '(')
            {
                stack.push(ans);
                stack.push(sign);
                ans = 0;//Thses 2 variables(ans and sign) are again set back to the default value to calculate the value inside the parenthesis
                sign = 1;
            }

            else if(s.charAt(i) == ')')
            {
                int prevSign = stack.pop();
                ans = prevSign * ans;//The value with sign
                int prevAns = stack.pop();
                ans = ans + prevAns;
            }
        }
        return ans;
    }
}