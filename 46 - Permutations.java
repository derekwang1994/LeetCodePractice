// Given a collection of distinct numbers, return all possible permutations.
// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]


public class Solution {
    public List<List<Integer>> permute(int[] nums) {

       List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       permute(list, new ArrayList<>(), nums);
       return list;

    }

    private void permute(List<List<Integer>> list, List<Integer> tempList, int [] nums){
       if(tempList.size() == nums.length){

          list.add(new ArrayList<>(tempList));

       } else{

          for(int i = 0; i < nums.length; i++){
             if(tempList.contains(nums[i])) continue; // element already exists, skip

             tempList.add(nums[i]);
             permute(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }

       }
    }
}
