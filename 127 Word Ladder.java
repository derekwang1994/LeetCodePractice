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
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);

        if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)

        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();

            for (String word : qs) {
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself

                        chars[j] = c;
                        String temp = String.valueOf(chars);

                        if (qe.contains(temp)) return len; // meet from two ends

                        if (dict.contains(temp) && vis.add(temp)){
                            nq.add(temp); // not meet yet, vis is safe to use
                        }
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }
}
