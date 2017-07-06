// Given a set of candidate numbers (C) (without duplicates) and a target number (T)
// , find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7,
// A solution set is:
// [
//   [7],
//   [2, 2, 3]
// ]


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        doBackTrack(candidates, target, result, new ArrayList<>(), 0, 0);

        return result;

    }
    public void doBackTrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int sum, int start){

        if(sum==target){
            result.add(new ArrayList<>(temp));
        }else if(sum>target){
            return;
        }else{
            for(int i=start; i<candidates.length; i++){

                sum += candidates[i];
                temp.add(candidates[i]);
                doBackTrack(candidates, target, result, temp, sum, i);
                temp.remove(temp.size()-1);
                sum -= candidates[i];

            }
        }

    }

}
