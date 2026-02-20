class Solution {
    public int maxProduct(int[] nums) {
        int bestEnding1  = nums[0];
        int bestEnding2 = nums[0];
        int result = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            int v1= bestEnding1 * nums[i];
            int v3 =  bestEnding2 * nums[i];
            int v2 = nums[i];
            bestEnding1 = Math.max(v3,Math.max(v1 , v2));
            bestEnding2 = Math.min(v3,Math.min(v1 , v2));
            result = Math.max(result,Math.max(bestEnding2 , bestEnding1));
        }
        return result;
    }
}