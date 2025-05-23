// Here, as it is that "smallest element in nums divides all the elements of numsDivide" it means that that no. must be either a factor of the GCD of all the elements in the numsDivide array or the GCD itself.

// ALso, we will sort the nums array so that we get the smallest no. and also we don't need to worry about the dublicates.

// Now, to check whether the nums array has any element which is a factor of GCD, we iterate through each element of the nums array(after it being sorted) and check whether any element divides the GCD or not. 

// here, TC = O(n log n + m log(max_value)) 

class Solution 
{
    public int minOperations(int[] nums, int[] numsDivide) 
    {
        int gcd = findGCD(numsDivide);

        Arrays.sort(nums);

        //Iterating from the smallest to the largest in the nums array
        for(int i=0; i < nums.length; i++)
        {
            if(gcd % nums[i] == 0)
            return i;
        }

        return -1;
    }

    int findGCD(int[] numsDivide )
    {
        int gcd = numsDivide[0];

        for(int i=1; i < numsDivide.length; i++)
        {
            int num = numsDivide[i];

            while(num > 0)
            {
                int temp = gcd % num;
                gcd = num;
                num = temp;
            }
        }

        return gcd;
    }
}