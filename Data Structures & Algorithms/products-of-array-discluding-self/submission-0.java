class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] asc = new int[nums.length];
        int[] dsc = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            asc[i] = product;    
        }
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            dsc[i] = product;
        }
        int[] output = new int[nums.length];
        output[0] = dsc[1];
        output[nums.length - 1] = asc[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i++){
            output[i] = asc[i - 1] * dsc[i + 1];
        }
        return output;
    }
}  
