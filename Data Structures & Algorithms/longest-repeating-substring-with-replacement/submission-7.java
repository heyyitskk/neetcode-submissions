class Solution {
    public int characterReplacement(String s, int k) { 
        int maxFreq = 0, i = 0;
        int maxWinSize = 0; 
        int[] freq = new int[26]; 
        for(int j = 0; j < s.length(); j++){ 
            freq[s.charAt(j) - 'A']++; 
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']); 
            if(((j - i + 1) - maxFreq) > k){ 
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            maxWinSize = Math.max(maxWinSize, j - i + 1); 
        } 
        return maxWinSize; 
    }
}