//OPtimised Bottom-Up DP

class Solution 
{
    public int minDistance(String word1, String word2) 
    {
        int n = word1.length();
        int m = word2.length();
        // dp[i][j]: edit distance between word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Base cases:
        // dp[0][j]: transform empty word1 to first j chars of word2: need j inserts
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        // dp[i][0]: transform first i chars of word1 to empty word2: need i deletes
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int deleteCost = dp[i - 1][j] + 1;    // delete word1[i-1]
                    int insertCost = dp[i][j - 1] + 1;    // insert word2[j-1]
                    int replaceCost = dp[i - 1][j - 1] + 1; // replace word1[i-1] with word2[j-1]
                    dp[i][j] = Math.min(deleteCost, Math.min(insertCost, replaceCost));
                }
            }
        }
        return dp[n][m];
    }
}
