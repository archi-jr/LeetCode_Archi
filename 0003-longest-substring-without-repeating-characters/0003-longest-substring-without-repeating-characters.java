// Note: All characters ASCII values are ij range 0-255

// Brute Force:
// Here we run 2 loops and generate every possible substring possible. Then inside that inner loop only we will check whether that substring has a repeating character using Hash Map(The Hash Map should be of size 256 to store all the possible characters and should be initialised to 0, initially). If from the Hash Map we see that there is repeating character then we break from the inner loop and continue to the outer loop. But, if there is no repeating character, then we check whether its length is greater than the previously stored max. length.
// We keep on iterating, and at the last we return the variable storing the Max. Length.
// Here, TC: O(N^2)//coz, using 2 loops
// SC: O(256)//coz, we are using Hash Map of size 256


// Optimised Solution:
// Whenever, it is said to find max. Substring always use 2-pointer and Sliding Window.
// Here, along with them we also use a Hash Map to remember which characters we have already visited.
// Here, TC: O(N), because of the while loop
// SC: O(256)

class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        // HashMap to store character and its latest index
        HashMap<Character, Integer> hash = new HashMap<>();
        
        int n = s.length();

        int l = 0;//Left pointer
        int r = 0;//Right pointer
        int max = 0;

        while(r < n)
        {
            char currentChar = s.charAt(r);

             // If character is already in HashMap and its index is >= l
            if(hash.containsKey(currentChar)) 
            {
                if(hash.get(currentChar) >= l) 
                {
                    l = hash.get(currentChar) + 1;
                }
            }

            int len = r-l+1;
            max = Math.max(len, max);

            // Update character position
            hash.put(currentChar, r);
            r++;
        }

        return max;
    }
}