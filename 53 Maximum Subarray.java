// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.

class Solution {
    public int maxSubArray(int[] nums) {
        int MaxSoFar = nums[0];
        int MaxEndingHere = nums[0];

        for(int i=1; i<nums.length; i++){
            MaxEndingHere = Math.max(MaxEndingHere + nums[i], nums[i]);
            MaxSoFar = Math.max(MaxSoFar, MaxEndingHere);
        }
        
        return MaxSoFar;
    }
}
