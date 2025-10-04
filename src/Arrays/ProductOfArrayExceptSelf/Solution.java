package Arrays.ProductOfArrayExceptSelf;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = nums[i] * prefixSum[i - 1];
        }

        suffixSum[nums.length - 1] = nums[nums.length - 1];
        for(int j = nums.length - 2; j > 0; j--){
            int index = j + 1;
            suffixSum[j] = nums[j] * suffixSum[j + 1];
        }


        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = 1;
            if(i - 1 >= 0){
                result[i] = result[i] * prefixSum[i - 1];
            }
            if(i + 1 < nums.length){
                result[i] = result[i] * suffixSum[i + 1];
            }
        }
        return result;
    }
}
