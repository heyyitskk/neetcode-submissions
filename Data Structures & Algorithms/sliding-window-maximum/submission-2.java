class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        int r = 0, l = 0;
        
        while(r < n){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);
            if(l > q.peekFirst()){
                q.removeFirst();
            }
            if((r + 1) >= k){
                result[l] = nums[q.peekFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
