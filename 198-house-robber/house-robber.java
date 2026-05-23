class Solution {
    // int[] dp = new int[101];
    // public int rob(int[] nums) {
    //     Arrays.fill(dp , -1);
    //     return solve(nums,0);
    // }

    // //Tabulation
    // private int solve(int[] nums , int idx){
    //     if(idx >= nums.length) return 0;
    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
    //     int skip = solve(nums,idx+1);
    //     int steal = nums[idx] + solve(nums,idx+2);

    //     dp[idx] = Math.max(skip,steal);
    //     return dp[idx];

    // }

    //recursive
    // private int solve(int[] nums , int idx){
    //     if(idx >= nums.length) return 0;
    //     if(dp[idx] != -1){
    //         return dp[idx];
    //     }
    //     int skip = solve(nums,idx+1);
    //     int steal = nums[idx] + solve(nums,idx+2);

    //     dp[idx] = Math.max(skip,steal);
    //     return dp[idx];

    // }

    //Bottom-Up Approach
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     if(n == 1) return nums[0];
    //     int[] dp = new int[n+1];

    //     dp[0] = 0;
    //     dp[1] = nums[0];

    //     for(int i = 2 ; i <= n ; i++){

    //         int skip = dp[i-1];
    //         int steal = nums[i - 1] + dp[i - 2];

    //         dp[i] = Math.max(skip,steal);
    //     }

    //     return  dp[n];
    // }



    // //Practice 2

    // // //Recursion + Memoization
    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length+1];
    //     Arrays.fill(dp , -1);
    //     return solver(0 , nums , dp);
    // }
    // public int solver(int i , int[] nums , int[] dp){
    //     // int profit = 0;
    //     if(i >= nums.length){
    //         return 0;
    //     }
    //     if(dp[i] != -1) return dp[i];
    //     int skip = solver(i+1 , nums , dp);
    //     int steal = nums[i] + solver(i+2 , nums , dp);
        
    //     return  dp[i] = Math.max(skip , steal);
    // }

    // //Tabulation
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n+1];

        
    // }

    // //Practice 3
    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length + 1];
    //     Arrays.fill(dp,-1);
    //     return solve(0 , nums ,dp);
    // }

    // public int solve(int idx , int[] nums , int[] dp){
    //     if(idx >= nums.length) return 0;
    //     if(dp[idx] != -1) return dp[idx];
    //     int take = nums[idx] + solve(idx+2 , nums, dp);
    //     int skip = solve(idx+1 , nums,dp);

    //     return dp[idx] = Math.max(take,skip);
    // }

    //TAvbulTION
    // public int rob(int[] nums) {
    //     int[] dp = new int[nums.length + 1];
    //     dp[0] = 0;
    //     dp[1] = nums[0];

    //     for(int i = 2 ; i <= nums.length ; i++){
    //         int take = nums[i-1] + dp[i-2];
    //         int skip = dp[i-1];

    //         dp[i] = Math.max(take,skip);
    //     }
    //     return dp[nums.length];

    // }

    //Practice 4
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return solve(0 , nums , dp);
    }
    int solve(int i , int[] nums , int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int skip = solve(i+1 , nums , dp);
        int steal = nums[i] + solve(i+2 , nums , dp);

        return dp[i] = Math.max(skip , steal);
    }
}