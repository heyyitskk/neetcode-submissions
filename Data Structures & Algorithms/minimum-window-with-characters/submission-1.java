class Solution {
    public String minWindow(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        if(s.length() < t.length() || t.isEmpty()) return "";
        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }
        int have = 0, need = 0;
        for(int ch : mapT) {
            if(ch > 0) need++;
        }
        int minLen = s.length() + 1, minL = 0, minR = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            mapS[s.charAt(r)]++;
            if(mapS[s.charAt(r)] == mapT[s.charAt(r)]) have++;
            while(have == need){
                if(minLen > r - l + 1){
                    minLen = r - l + 1;
                    minL = l;
                }
                if(mapS[s.charAt(l)] == mapT[s.charAt(l)]) have--;
                mapS[s.charAt(l)]--;
                l++;
            }
        }
        return (minLen == s.length() + 1) ? "" : s.substring(minL, minL + minLen);
    }
}
