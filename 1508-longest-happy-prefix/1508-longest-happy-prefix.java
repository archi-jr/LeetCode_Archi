// Note: Prefix means a substring whose 1st letter is always the 1st letter of that string(i.e, a substring starting from the LHS of the string always)

// Suffix means a substring whose last letter is always the last letter of that string(i.e, a substring starting from the RHS of the string always) 

// Here, we will be using KMP Algo(can watch Abdul Bari's vodeo for topic clearance)

// Brute Force:
// 1st we will create all Prefixes for the string and then we will check for each of those Prefix whether there is a valid Suffix r not. If yes we will store that length and keep on creating newer Prefixes and check whether its Suffix exits and if yes, whether its length is Longer.
// Here, TC - O(N^2)

// Optimised solution:
// We solve it by the help of KMP Algo. We use the LPS array concept to find th length of the longest prefix which is also the suffi. And then just using that length we etract the substring from the beginning. hencem that's our answer.

class Solution 
{
    public String longestPrefix(String s) 
    {
        int n = s.length();
        int i=1, len = 0;

        int lps[] = new int[n]; //it shores the indexes i the form of KMP

        while( i < n)
        {
            if(s.charAt(i) == s.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }

            else
            {
                if(len != 0)
                {
                    len = lps[len - 1]; //Use previous LPS Value
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        String ans = "";
        ans = s.substring(0, lps[n-1]);
        return ans;
    }
}