class Solution 
{
    int solve(String s, String p, int i, int j, int dp[][]) 
    {
        // Base Case
        if (i < 0 && j < 0)
            return 1; // true
        
        if (i >= 0 && j < 0)
            return 0; // false
        
        if (i < 0 && j >= 0) 
        {
            for (int k = 0; k <= j; k++) 
            {
                if (p.charAt(k) != '*')
                    return 0; // false
            }
            return 1; // true
        }
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        // Match
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return dp[i][j] = solve(s, p, i - 1, j - 1, dp);
        
        else if (p.charAt(j) == '*')
            return dp[i][j] = (solve(s, p, i - 1, j, dp) == 1 || solve(s, p, i, j - 1, dp) == 1) ? 1 : 0;
        else
            return dp[i][j] = 0; // false
    }
    
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        
        return solve(s, p, s.length() - 1, p.length() - 1, dp) == 1;
    }
}