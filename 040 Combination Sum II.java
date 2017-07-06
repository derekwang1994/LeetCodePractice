// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// Each number in C may only be used once in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doBackTrack(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;

    }
    public void doBackTrack(int[] candidates, int remain, List<List<Integer>> result, List<Integer> temp, int start){
        if(remain<0){
            return;
        }else if(remain==0){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i=start; i<candidates.length; i++){
                if(i>start && candidates[i]==candidates[i-1]) continue;

                temp.add(candidates[i]);

                doBackTrack(candidates, remain - candidates[i], result, temp, i+1);

                temp.remove(temp.size()-1);

            }
        }
    }
}
