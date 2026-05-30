class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int maxFreq = 0;
        int maxWindowSize = 0;
        int[] freq = new int[26];

        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int charsToReplace = (j - i + 1) - maxFreq;
            while(charsToReplace > k){
                freq[s.charAt(i) - 'A']--;
                i++;
                charsToReplace = (j - i + 1) - maxFreq;
            } 
            maxWindowSize = Math.max(maxWindowSize, (j - i + 1));
        }
        return maxWindowSize;
    }
}