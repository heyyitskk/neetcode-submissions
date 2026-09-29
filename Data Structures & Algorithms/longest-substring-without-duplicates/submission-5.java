class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int maxLength = 0;
        Set<Character> unique = new HashSet<>();
        for(int j = 0; j < s.length(); j++){
            while(unique.contains(s.charAt(j))){
                unique.remove(s.charAt(i));
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            unique.add(s.charAt(j));
        }
        return maxLength;
    }
}
