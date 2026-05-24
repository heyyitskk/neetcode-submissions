class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] asc = new int[n];
        int[] dsc = new int[n];
        int product = 1;
        for(int i = 0; i < n; i++){
            product *= nums[i];
            asc[i] = product;    
        }
        product = 1;
        for(int i = n - 1; i >= 0; i--){
            product *= nums[i];
            dsc[i] = product;
        }
        int[] output = new int[n];
        output[0] = dsc[1];
        output[n - 1] = asc[n - 2];
        for(int i = 1; i < n - 1; i++){
            output[i] = asc[i - 1] * dsc[i + 1];
        }
        return output;
    }
}  
