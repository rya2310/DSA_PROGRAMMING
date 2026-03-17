class Solution {

    //Foe loop
    // time complexcity O(N) spacwe complexcity O(1)
    // public static int fib(int n) {
    //     if( n <= 1) return n;
    //     int p1 = 0;
    //     int p2 = 1;
    //     // int curr = 0;
    //     for(int i = 2; i<= n ; i++){
    //         int curr = p1 + p2;
    //         p1 = p2;
    //         p2 = curr;  
    //     }
    //     return p2;
    // }
    
    
    // Memoization Approach
    // T(n) = O(N);
    // public static Integer[] dp = new Integer[46];
    // public static int fib(int n) {
    //     if (n <= 1) return n;

    //     if(dp[n] != null) return dp[n];

    //     dp[n] = fib(n-1) + fib(n-2);
    //     return dp[n];
    // }

    // Tabulation Approach(Bottom-Up Approach)
    // public static int fib(int n) {
    //     if (n <= 1)
    //         return n;
    //     int dp[] = new int[n+1];
    //     dp[0] = 0;
    //     dp[1] = 1;

    //     for(int i = 2 ; i<= n ; i++){
    //         dp[i] = dp[i-1] + dp[i - 2];
    //     }
    //     return dp[n];
    // }

    // public static int fib(int n) {
    //     if(n <= 1) return n;
    //     int[] dp = new int[n+1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     for(int i = 2 ; i <= n ; i++){
    //         dp[i] = dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }

    public static int fib(int n) {
        if(n <= 1) return n; 
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 1 ; i < n ; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}