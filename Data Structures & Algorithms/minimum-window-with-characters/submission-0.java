class Solution {
    public String minWindow(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        if(s.length() < t.length() || t.isEmpty()) return "";
        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }
        int minLen = Integer.MAX_VALUE, minL = 0, minR = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            mapS[s.charAt(r)]++;
            while(contains(mapT, mapS)){
                int len = (r - l + 1);
                if(minLen > len){
                    minLen = len;
                    minR = r;
                    minL = l;
                }
                mapS[s.charAt(l++)]--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
    private boolean contains(int[] mapT,int[] mapS){
        for(int i = 0; i < 256; i++){
            if(mapT[i] > mapS[i]) return false;
        }
        return true;
    }
}
