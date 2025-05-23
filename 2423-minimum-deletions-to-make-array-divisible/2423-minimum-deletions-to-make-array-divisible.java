// Now, we use a frequency map to avoid sorting while still processing elements in ascending order. 
// TC = O(n log k + m log(max_value))

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        // Find GCD of all elements in numsDivide
        int gcd = findGCD(numsDivide);
        
        // Use TreeMap to store frequency and maintain sorted order
        // TreeMap automatically sorts keys in ascending order
        Map<Integer, Integer> freqMap = new TreeMap<>();
        
        // Count frequency of each element in nums
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        int deletions = 0;
        
        // Iterate through elements in ascending order (TreeMap property)
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            
            // If current number divides GCD, return deletions needed
            if (gcd % num == 0) {
                return deletions;
            }
            
            // Add frequency to deletions (all occurrences need to be deleted)
            deletions += freq;
        }
        
        return -1; // No valid divisor found
    }
    
    // Optimized GCD calculation using Euclidean algorithm
    private int findGCD(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            
            // Early termination: if GCD becomes 1, it won't change
            if (result == 1) {
                break;
            }
        }
        
        return result;
    }
    
    // Helper method for GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}