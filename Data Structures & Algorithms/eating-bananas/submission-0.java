class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        int res = 0;
        for(int p : piles){
            r = Math.max(r, p);
        }
        while(l <= r){
            int mid = l + (r - l) / 2;
            long time = 0;
            for(int pile : piles){
                time += (int) Math.ceil((double) pile / mid);
            }
            if(time <= h){
                res = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return res;
    }
}
