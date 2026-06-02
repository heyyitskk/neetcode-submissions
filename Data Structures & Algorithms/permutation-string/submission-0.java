class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int i = 0, j = s1.length() - 1;
        for(i = 0; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++; 
            freq2[s2.charAt(i) - 'a']++; 
        }
        i = 0;
        while(j < s2.length()){
            if(Arrays.equals(freq1, freq2)) return true;
            freq2[s2.charAt(i) - 'a']--;
            i++;
            j++;
            if(j < s2.length())
                freq2[s2.charAt(j) - 'a']++;
        }
        return false;
    }
}
