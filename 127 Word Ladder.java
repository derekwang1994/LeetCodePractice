// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// UPDATE (2017/1/20):
// The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<String>(wordList); // HashSet has a faster .contains() method
        Set<String> startSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> visitedSet = new HashSet<String>();

        startSet.add(beginWord);
        if(dict.contains(endWord)){
            endSet.add(endWord);
        }else{
            return 0;
        }

        int level = 0;

        while(!startSet.isEmpty()){
            Set<String> tempSet = new HashSet<String>();

            for(String word : startSet){
                for(int i=0; i<word.length();i++){
                    char[] chars = word.toCharArray();

                    for(char c='a'; c<='z'; c++){
                        if( c == chars[i] ) continue; // beginWord and endWord not the same, so bypass itself

                        chars[i] = c;
                        String tempString = new String(chars);

                        if(endSet.contains(tempString)) return level+2;  // meet from two ends

                        if(dict.contains(tempString) && !visitedSet.contains(tempString)){ // not meet yet, visitedSet is safe to use
                            tempSet.add(tempString);
                            visitedSet.add(tempString);
                        }
                    }
                }
            }

            startSet = (tempSet.size() < endSet.size()) ? tempSet : endSet;  // switch to small one to traverse from other end
            endSet = (startSet.equals(tempSet)) ? endSet : tempSet;
            level++;
        }
        return 0;
    }
}
