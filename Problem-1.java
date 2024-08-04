// Time Complexity for sorted array is : O(n * klogk)
// Space Complexity for hashmap with lists as values is  : O(n)
// Time Complexity for prime number is : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : nope but I did not full understand why need to use prime , cant we use ascii?


// Your code here along with comments explaining your approach: I implemented both hashmap and set approach Jaspinder explained.

class Solution {
    int[] prime;
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();
        this.prime = new int []{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 
            73, 79, 83, 89, 97, 101
        };

        for(String s: strs){
            // char [] sChar = s.toCharArray();
            // Arrays.sort(sChar);
            // String sorted = String.valueOf(sChar);
            double primeProduct = getPrimeProduct(s);
            if(!map.containsKey(primeProduct)){
                map.put(primeProduct, new ArrayList<>());
            }
            map.get(primeProduct).add(s);

        }

        return new ArrayList<>(map.values());
    }

    private double getPrimeProduct(String s){
        double result = 1;
        for(int i = 0; i < s.length(); i++){
            result *= prime[s.charAt(i) - 'a'];
            // result *= s.charAt(i) - 'a';
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char [] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String sorted = String.valueOf(sChar);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);

        }

        return new ArrayList<>(map.values());
    }
}