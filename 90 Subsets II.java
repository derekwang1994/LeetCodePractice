// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
// Note: The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,2], a solution is:
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

Recursion:
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> list, List<Integer> tempList){
        list.add(new ArrayList<>(tempList));
        for(int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, i+1, list, tempList);
            tempList.remove(tempList.size()-1);
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
        }
    }
}

Iterative:
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        int size = 0;
        int startIndex;
        for(int i=0; i<nums.length; i++){
            startIndex = (i>=1 && nums[i]==nums[i-1]) ? size : 0;
            size = list.size();

            for(int j=startIndex; j<size; j++){
                List<Integer> tempList = new ArrayList<>(list.get(j));
                tempList.add(nums[i]);
                list.add(tempList);
            }

        }

        return list;
    }
}
