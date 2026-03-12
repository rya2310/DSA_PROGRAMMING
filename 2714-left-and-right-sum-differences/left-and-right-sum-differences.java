class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int n = nums.length;
        leftSum[0] = 0;
        rightSum[nums.length-1] = 0;
        for(int i = 1 ; i < n ; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
            
        }
        for(int i = n-2 ; i >= 0 ; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1]; 
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}