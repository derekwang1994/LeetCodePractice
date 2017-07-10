// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note: All inputs will be in lower-case.

// Transform the String to CharArray and use the Array.sort function to sort it and transform back to String. //
// Use the sortedString as key to check if the map containsKey. //
// Finally, use Map.Entry to iterate through map, put each Value into the result list. //

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>();
        if(strs==null) return list;

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs ){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if(map.containsKey(sortedString)){
                List<String> tempList = map.get(sortedString);
                tempList.add(str);
                map.put(sortedString, tempList);
            }else{
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(sortedString, tempList);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }

        return list;
    }
}
