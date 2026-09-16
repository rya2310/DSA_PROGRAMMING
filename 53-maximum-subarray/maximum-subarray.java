class Solution {
    public int maxSubArray(int[] nums) {
        int bestending = nums[0] ;
        int ans = nums[0] ;

        for(int i = 1 ; i < nums.length ; i++){
            
            bestending = Math.max(bestending + nums[i] , nums[i]);
            ans = Math.max(ans , bestending) ;
        }
        return ans;
    }
}