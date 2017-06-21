// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


// 和原本的3Sum一樣，使用夾擊法 //

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int closest = nums[0]+nums[1]+nums[2]; // 任意給一個陣列中會出現的和 //

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){

                int sum = nums[i]+nums[low]+nums[high];

                if(Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;

                if(sum > target){
                    high--;
                }else{
                    low++;
                }

            }
        }

        return closest;
    }
}
