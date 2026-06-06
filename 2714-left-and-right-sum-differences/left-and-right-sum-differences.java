class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        leftSum[0] = 0;
        rightSum[nums.length-1] = 0;
        int[] ans = new int[nums.length];

        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                leftSum[i]  += nums[j] ;
            }
        }

        for(int i = nums.length-2 ; i >= 0 ; i--){
            for(int j = nums.length-1 ; j > i ; j--){
                rightSum[i]  += nums[j] ;
            }
        }

        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return ans;
    }
}