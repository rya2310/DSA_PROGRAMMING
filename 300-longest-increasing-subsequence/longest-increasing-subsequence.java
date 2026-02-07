class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        for(int[] i : memo)
        {
            Arrays.fill(i,-1);
        }
        return solver(-1 , 0 , nums , memo);
    }
    public int solver(int p , int i , int[] arr , int[][] memo){
        if(i >= arr.length) return 0;
        int take = Integer.MIN_VALUE;
        if(memo[p+1][i] != -1) return memo[p+1][i];
        if(p == -1 || arr[i] > arr[p]){
            take = Math.max(take , 1+solver(i , i+1 , arr,memo));
        }
        int notTake = solver(p , i+1 , arr,memo);
        return memo[p+1][i]=Math.max(take ,notTake);
    }
}