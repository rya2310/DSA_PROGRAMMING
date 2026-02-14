class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int totalSum = nums[0];
        for(int t = 1 ; t < n ; t++){
            totalSum += nums[t]; 
        }

        int leftSum = 0;

        for(int i = 0 ; i < n ; i++){
            int rightSum = totalSum - leftSum - nums[i];

            if(rightSum == leftSum){
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}