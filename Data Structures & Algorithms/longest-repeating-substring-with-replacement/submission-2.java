class Solution {
    public int characterReplacement(String s, int k) { 
        int maxFreq = 0, i = 0, j = 0;
        int charToReplace = 0, maxWinSize = 0; 
        int[] freq = new int[26]; 
        while(j < s.length()){ 
            freq[s.charAt(j) - 'A']++; 
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']); 
            if(((j - i + 1) - maxFreq) > k){ 
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            maxWinSize = Math.max(maxWinSize, j - i + 1); 
            j++; 
        } 
        return maxWinSize; 
    }
}