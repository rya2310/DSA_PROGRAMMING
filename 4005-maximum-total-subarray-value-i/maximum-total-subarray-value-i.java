class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long res = 1;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max , nums[i]);
            min = Math.min(min , nums[i]);
        }
        return  res = res * (max - min) * k; 
   }
}