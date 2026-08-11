class Solution {
    // public int rob(int[] nums) {
    //     int[] dp =  new int[nums.length];
    //     if(nums.length == 1 ) return nums[0];
    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0] , nums[1]);

    //     for(int i = 2 ; i < nums.length ; i++){
    //         dp[i] = Math.max(dp[i-2]+nums[i] , dp[i-1]);
    //     }
    //     return dp[nums.length-1];
    // }   

    public int rob(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return solve( 0 , nums , dp);
    }

    public int solve(int i , int[] nums , int[] dp){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        int take = nums[i] + solve(i+2 , nums , dp);

        int skip = solve(i+1 , nums , dp);

        return dp[i] = Math.max(take , skip);
    } 
}