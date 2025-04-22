// Brute Force: Create all the Subsequences(either by Recursive Method or Power Set Method). Check for Pallindorme. And print the longest among all of them.

// Now, the Optimised Approach: Here we use the logic of LCS(longest Common Subsequence). Here, for that Pallindromic constraint rather than thinking much we will reverse our Original STring itself. And, to find the Longest Common Subsequence among both of them(ie, the Original String and the Reversed string) we call the LCS function.
// hence, we will get the LCS and that will be pallindromic as we have reversed the string itself.

// Optimised Solution:

class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        
        int n = s.length();
        int start = 0, maxLength = 1;
        
        // Expand around center technique
        for (int i = 0; i < n; i++) {
            // For odd length palindromes
            expandAroundCenter(s, i, i, start, maxLength);
            
            // For even length palindromes
            expandAroundCenter(s, i, i + 1, start, maxLength);
        }
        
        return s.substr(start, maxLength);
    }
    
private:
    void expandAroundCenter(const string& s, int left, int right, int& start, int& maxLength) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            left--;
            right++;
        }
        
        // Calculate length of palindrome (right-left-1)
        int length = right - left - 1;
        if (length > maxLength) {
            maxLength = length;
            start = left + 1;
        }
    }
};

// This solution uses the "expand around center" technique which is a more efficient approach for finding the longest palindromic substring:

// For each character in the string, we try to expand around it (for odd-length palindromes)
// For each pair of adjacent characters, we try to expand around them (for even-length palindromes)
// We keep track of the longest palindrome found

// The time complexity is O(n²) where n is the length of the string, and the space complexity is O(1) as we only use a constant amount of extra space.
// This algorithm is correct because it directly verifies palindromic properties rather than relying on LCS, which doesn't account for positional constraints required for a valid palindrome.