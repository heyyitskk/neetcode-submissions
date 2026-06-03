class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int maxLength = 0;
        Set<Character> unique = new HashSet<>();
        for(;j < s.length(); j++){
            if(unique.contains(s.charAt(j))){
                while(unique.contains(s.charAt(j))){
                    unique.remove(s.charAt(i));
                    i++;
                }
            }
            maxLength = Math.max(maxLength, j - i + 1);
            unique.add(s.charAt(j));
        }
        return maxLength;
    }
}
