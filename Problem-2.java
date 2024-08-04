// Time Complexity : O(n)
// Space Complexity : O(1) as map can hold 26 characters only.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach: I implemented both hashmap and set approach Jaspinder explained.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();

        for(int i = 0; i < s.length(); i++){
            if(sMap.containsKey(sChar[i])){
                if(sMap.get(sChar[i]) != tChar[i] ){
                    return false;
                }
            }else{
                sMap.put(sChar[i],tChar[i]);
            }

            if(tMap.containsKey(tChar[i])){
                if(tMap.get(tChar[i]) != sChar[i] ){
                    return false;
                }
            }else{
                tMap.put(tChar[i],sChar[i]);
            }
        }
        return true;
    }
}