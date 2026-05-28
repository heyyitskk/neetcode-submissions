class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int maxLength = 0;
        Map<Character, Integer> unique = new HashMap<>();
        while(j < s.length()){
            if((!unique.containsKey(s.charAt(j))) || unique.get(s.charAt(j)) < i){
                unique.put(s.charAt(j), j);
                int length = j - i + 1;
                maxLength = Math.max(length, maxLength);
                j++;
            }
            else{
                i = unique.get(s.charAt(j)) + 1
                ;
            }
        }
        return maxLength;
    }
}
