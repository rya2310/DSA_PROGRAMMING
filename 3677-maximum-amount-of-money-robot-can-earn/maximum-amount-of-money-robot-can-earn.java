import java.util.*;

class Solution {
    int m, n;
    int[][][] dp;

    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        dp = new int[m][n][3];

        for(int[][] layer : dp){
            for(int[] row : layer){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, coins, 2);
    }

    public int solve(int i, int j, int[][] coins, int neu){
        if(i >= m || j >= n) return Integer.MIN_VALUE;

        if(dp[i][j][neu] != Integer.MIN_VALUE){
            return dp[i][j][neu];
        }

        if(i == m-1 && j == n-1){
            if(coins[i][j] < 0 && neu > 0){
                return dp[i][j][neu] = 0;
            }
            return dp[i][j][neu] = coins[i][j];
        }

        int take = coins[i][j] + Math.max(
            solve(i+1, j, coins, neu),
            solve(i, j+1, coins, neu)
        );

        int skip = Integer.MIN_VALUE;

        if(coins[i][j] < 0 && neu > 0){
            skip = Math.max(
                solve(i+1, j, coins, neu-1),
                solve(i, j+1, coins, neu-1)
            );
        }

        return dp[i][j][neu] = Math.max(take, skip);
    }
}