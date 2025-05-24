// Brute Force: WE find out al the possible Sub-strings and count those sub-strings which contain al substrings.

// But, here TC: O(N^2)

// OPtimised solution:

// Logic: With every character, there is a substring that ends with that character.
// Hence, now we use the ""Sliding window" to find out min. string with all the 3 characters then count all the substrings which are possible with it.

// Here, TC = O(N) 
// SC = O(1)

class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int lastseen[] = {-1, -1, -1};//TO store the indices of ab and c respectively.
        int cnt = 0;
        int n= s.length();

        for(int i=0; i<n; i++)
        {
            lastseen[s.charAt(i) - 'a'] = i;

            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1)
            {
                cnt = cnt + (1 + Math.min(Math.min(lastseen[0], lastseen[1]), lastseen[2]));
            }
        }

        return cnt;

    }
}