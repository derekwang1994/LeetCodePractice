// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.
//
// extension of LeetCode 053

class Solution {
    public int maxProduct(int[] nums) {

        int MaxSoFar = nums[0];
        int MaxHerePre = nums[0];
        int MinHerePre = nums[0];
        int MaxEndingHere, MinEndingHere;

        for(int i=1; i<nums.length; i++){

            MaxEndingHere = Math.max(Math.max(MaxHerePre * nums[i], MinHerePre * nums[i]), nums[i]);
            MinEndingHere = Math.min(Math.min(MaxHerePre * nums[i], MinHerePre * nums[i]), nums[i]);

            MaxSoFar = Math.max(MaxSoFar, MaxEndingHere);

            MaxHerePre = MaxEndingHere;
            MinHerePre = MinEndingHere;
        }

        return MaxSoFar;
    }
}
