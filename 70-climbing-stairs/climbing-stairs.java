class Solution {
    
    // //Space Optimization
    // public int climbStairs(int n){
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;
    //     int p2 = 1; 
    //     int p1 = 2; 
    //     int curr = 0;
    //     for(int i = 3;i <= n ; i++){
    //         curr = p1 + p2; 
    //         p2 = p1;
    //         p1 = curr;
    //     } 
    //     return curr;
    // }
    // //Memoization Approach
    // // private static Integer[] dp = new Integer[46];
    // // public int climbStairs(int n){
    // //     if(n <= 1) return n;
    // //     if(n == 1) return 1;
    // //     if(n == 2) return 2;
    // //     if(dp[n]!= null) return dp[n];

    // //     dp[n] = climbStairs(n-1) + climbStairs(n-2);
    // //     return dp[n];
    // // }


    // //Tabulation Approach
    // // public int climbStairs(int n) {
    // //     if(n <= 2) return n;
    // //     int[] dp = new int[n+1];
    // //     dp[0] = 0;
    // //     dp[1] = 1;
    // //     dp[2] = 2;
    // //     dp[3] = 3;
    // //     for(int i = 3 ; i <= n ; i++){
    // //         dp[i] = dp[i-1] + dp[i-2];
    // //     }
    // //     return dp[n];
    // // }

    // Practice 2
    //Recursion + dp
    // public int climbStairs(int n){
    //     int[] dp= new int[n+1];
        
    //     Arrays.fill(dp , -1);
    //     return solver(0 , n , dp);
    // }
    // public int solver(int i , int n , int[] dp){
    //     if(i > n) return 0;
    //     if(i == n) return 1;
    //     if(dp[i] != -1) return dp[i];
    //     return dp[i] = solver(i+1 , n , dp) + solver(i+2 , n , dp);
    // }

    //Tabulation
    public int climbStairs(int n){
        int[] dp =new int [n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    public int solve(int n , int[] dp){
        if(n == 0) return 1;
        if(n < 0 )return 0;
        if(dp[n] != -1) return dp[n];
        return dp[n] =  solve(n-2 , dp) + solve(n-1 , dp);
    } 
}