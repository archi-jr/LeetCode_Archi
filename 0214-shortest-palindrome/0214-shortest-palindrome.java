// Note: It is always possible to make a String Pallindrome by appending characters in the beginning. We need Max. (n-1) characters to be inserted in the beginning Greedily for converting it into Pallindrome.

// Main Masala: we want the Longest Length of the Prefix to be Pallindrome. Thus, find the Longest Pallindromic Prefix. And the rest of the string we append at the beginning and that particular string's length is the least no. of appendings we need to make.  
 
// Here, we will use the logic that: Prefix(S) = Reverse of Suffix(Srevered); where S is the given string.
// Thus, our goal will be to find the Longest Pallindromic Prefix, using KMP Algo.

// We use, LPS on a new String = "S * Srev" ; where * is the seperator.

// Thus, in the main string S we find the Longest Palindromic prefix. and we keep that part and the rest of the string is concatenated at the beginning to make it a pallindrome.

// Here, TC = O(N)
// and SC = O(N)

class Solution 
{
    public String shortestPalindrome(String s) 
    {
        int n = s.length();

        String original = s;

        String reverse = "";

        for(int i= n-1; i>=0; i--)
        {
            char ch = s.charAt(i);
            reverse = reverse + ch;
        }

        String str = original + "*" + reverse;

        //Apply KMP String matching
        int lps[] = new int[2*n+1];//The last index of this lps array will give me the length of the longest Pallindromic prefiz

        int i=0, j=1;
        while(j < str.length())
        {
            if(str.charAt(i) == str.charAt(j))
            {
                lps[j] = i+1;
                i++;
                j++;
            }

            if(j == str.length())
            break;
            
            if(str.charAt(i) != str.charAt(j))
            {
                if(i > 0)
                i = lps[i-1];
                else
                {
                    lps[j] = 0;
                    j++;
                }
            }
        }

        //Find the no. of characters to be appended at the beginning
        int diff = n - lps[2*n];

        //Append these characters to the beginning of the initial string 
        original = reverse.substring(0,diff) + original;

        return original;
    }
}