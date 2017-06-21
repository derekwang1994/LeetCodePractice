// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];

        permuteUnique(nums, temp, result, used);

        return result;
    }

    public void permuteUnique(int[] nums, List<Integer> temp, List<List<Integer>> result, boolean[] used){
        if(temp.size()==nums.length){

            result.add(new ArrayList<Integer>(temp));

        }else{

            for(int i=0; i<nums.length; i++){

                if( used[i]==true ) continue; // 跳過已經加進temp的 //

                used[i] = true;
                temp.add(nums[i]);
                permuteUnique(nums, temp, result, used);
                temp.remove(temp.size() - 1);
                used[i] = false;

                // 跳過重複的數字 //
                while(i <nums.length-1 && nums[i]==nums[i+1]){
                    i++;
                }

            }
        }
    }
}
