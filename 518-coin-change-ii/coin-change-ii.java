class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return dfs(0, amount, coins , dp);
    }

    private int dfs(int idx, int amount, int[] coins , int[][] dp) {
        if (amount == 0) return 1;
        if (idx >= coins.length) return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take = 0;
        if(coins[idx] <= amount){
            take = dfs(idx , amount-coins[idx] , coins , dp);
        }

        int skip = dfs(idx + 1, amount, coins , dp);
        return dp[idx][amount] = take + skip ;
    }
}
