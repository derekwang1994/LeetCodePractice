// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// For example,
// If n = 4 and k = 2, a solution is:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(n, k, 1, list, new ArrayList<Integer>());
        return list;
    }

    private void backTrack(int n, int k, int start, List<List<Integer>> list, List<Integer> tempList){
        if(k==0){
            list.add(new ArrayList<Integer>(tempList));
            return;
        }

        for(int i=start; i<=n; i++){
            tempList.add(i);
            backTrack(n, k-1, i+1, list, tempList);
            tempList.remove(tempList.size()-1);
        }

    }
}
