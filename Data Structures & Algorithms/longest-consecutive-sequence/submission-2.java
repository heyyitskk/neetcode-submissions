class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> con = new HashSet<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            con.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(!con.contains(nums[i] - 1)){
                int num = nums[i];
                int count = 1;
                while(con.contains(++num)){
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
