// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.

// 夾擊法的概念，一個
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){

            int low = i+1;
            int high = nums.length-1;

            while(low<high){

                int target = -(nums[i]);

                if(nums[low] + nums[high] == target){

                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    low++;
                    high--;

                    while(low<high && nums[low]==nums[low-1]) low++;
                    while(low<high && nums[high]==nums[high+1]) high--;

                }else if(nums[low] + nums[high] > target){
                    high--;
                }else{
                    low++;
                }
            }

            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;

        }

        return result;
    }
}
