class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i <= m ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= n ; i++){
            dp[0][i] = i;
        }

        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
    // public int solver(int i , int j , String s , String t , int[][] dp){
    //     if(i == s.length()) return t.length() -j;
    //     if(j == t.length()) return s.length() -i;

    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(s.charAt(i) == t.charAt(j)){
    //         return dp[i][j] =  solver(i+1 , j+1 , s , t , dp);
    //     }
    //     int insert = solver(i , j+1 , s , t,dp);
    //     int delete = solver(i+1 , j , s , t,dp);
    //     int replace = solver(i+1 , j+1 , s ,t,dp);

    //     return dp[i][j] = 1+ Math.min(insert,Math.min(delete , replace));

    // }
}