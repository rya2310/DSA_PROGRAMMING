class Solution {
    public int[] leftRightDifference(int[] nums) {
        int curr = 0;
        int sum = 0;
        int[] ans = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
        }

        for(int i =0 ; i < nums.length ; i++){
            int leftSum =  curr;
            curr += nums[i];
            int rightSum = Math.abs(sum - curr);
            ans[i] = Math.abs(rightSum - leftSum);
        }
        return ans;
    }
}