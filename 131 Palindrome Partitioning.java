// Given a string s, partition s such that every substring of the partition is a palindrome.
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        dfs(s, 0, list, tempList);
        return list;
    }

    private void dfs(String s, int start, List<List<String>> list, List<String> tempList){
        if(start==s.length()){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i=start; i<s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i+1));
                    dfs(s, i+1, list, tempList);
                    tempList.remove(tempList.size()-1);
                }
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

}
