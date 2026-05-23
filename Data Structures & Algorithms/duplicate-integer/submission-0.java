class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!(dup.isEmpty())){
                if(dup.contains(nums[i])) return true;
            }
            dup.add(nums[i]);
        }
        return false;
    }
}