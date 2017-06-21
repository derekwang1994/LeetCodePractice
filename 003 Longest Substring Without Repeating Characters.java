// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
// Given "abcabcbb", the answer is "abc", which the length is 3.
// Given "bbbbb", the answer is "b", with the length of 1.
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring
//       , "pwke" is a subsequence and not a substring.

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();

        int max=0;

        int duplicateIndex=0;

        for(int i=0; i<s.length(); i++){
            if(temp.containsKey(s.charAt(i))){
                duplicateIndex = Math.max( duplicateIndex, temp.get(s.charAt(i))+1 ;
            }

            temp.put(s.charAt(i), i);
            max = Math.max(max, i - duplicateIndex +1);
        }

        return max;

    }
}
