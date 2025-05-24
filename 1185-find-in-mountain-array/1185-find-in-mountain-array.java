/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        // Find the Peak Element
        int lp = 1; // Left pointer
        int rp = length - 2; // Right pointer
        int peak = 0;

        while (lp <= rp) {
            int m = lp + (rp - lp) / 2; // Mid index

            int left = mountainArr.get(m - 1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m + 1);

            if (left < mid && mid < right) {
                // We're in ascending part, peak is to the right
                lp = m + 1;
            } else if (left > mid && mid > right) {
                // We're in descending part, peak is to the left
                rp = m - 1;
            } else {
                // We found the peak
                peak = m;
                break;
            }
        }

        // Search Left Portion for Target (ascending order)
        lp = 0;
        rp = peak;

        while (lp <= rp) {
            int m = lp + (rp - lp) / 2; // Mid index
            int val = mountainArr.get(m);

            if (val < target) {
                lp = m + 1;
            } else if (val > target) {
                rp = m - 1;
            } else {
                return m; // Found target in left portion
            }
        }

        // Search Right Portion for Target (descending order)
        lp = peak + 1; // Start after peak to avoid checking peak twice
        rp = length - 1;

        while (lp <= rp) {
            int m = lp + (rp - lp) / 2; // Mid index
            int val = mountainArr.get(m);

            if (val < target) {
                // In descending array, if val < target, target is to the left
                rp = m - 1;
            } else if (val > target) {
                // In descending array, if val > target, target is to the right
                lp = m + 1;
            } else {
                return m; // Found target in right portion
            }
        }

        return -1; // Target not found
    }
}