package DP.PartitionEqualSubsetSum;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int subsetSum = sum/2;
        boolean[] dp = new boolean[subsetSum + 1];
        dp[0] = true;
        for(int n : nums){
            for(int i = subsetSum; i >= n; i--){
                if(dp[i]){
                    continue;
                }
                if(dp[i - n]){
                    dp[i] = true;
                }
                if(dp[subsetSum]){
                    return true;
                }
            }
        }
        return false;
    }
}
