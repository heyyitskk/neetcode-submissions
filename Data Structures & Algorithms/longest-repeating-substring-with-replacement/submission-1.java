class Solution {
    public int characterReplacement(String s, int k) { 
        int maxFreq = 0, i = 0, j = 0;
        int charToReplace = 0, maxWinSize = 0; 
        Map<Character, Integer> freq = new HashMap<>(); 
        while(j < s.length()){ 
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0)+ 1); 
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(j))); 
            charToReplace = (j - i + 1) - maxFreq; 
            if(charToReplace > k){ 
                freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
                i++;
                charToReplace = (j - i + 1) - maxFreq; 
            }
            maxWinSize = Math.max(maxWinSize, j - i + 1); 
            j++; 
        } 
        return maxWinSize; 
    }
}