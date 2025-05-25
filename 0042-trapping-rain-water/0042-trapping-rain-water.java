class Solution {
    public int trap(int[] height) {
        // Create an array to store the maximum height to the left of each index
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        // Create an array to store the maximum height to the right of each index
        int rightmax[] = new int[height.length];
        rightmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        int trappwater = 0; // Variable to store total trapped water

        // Calculate trapped water at each index
        for (int i = 0; i < height.length; i++) {
            // Water level at current index is min of max heights on both sides
            int water = Math.min(leftmax[i], rightmax[i]);

            // Subtract the height of the current bar to get trapped water
            int sub = water - height[i];

            // Only add if trapped water is positive
            if (sub > 0) {
                trappwater += sub;
            }
        }

        return trappwater; // Return the total trapped water
    }
}
