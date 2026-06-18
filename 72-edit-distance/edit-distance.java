class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] i : dp){
            Arrays.fill(i , -1);
        }
        return solver(0 , 0 , word1 , word2 , dp);
    }
    public int solver(int i , int j , String s , String t , int[][] dp){
        if(i == s.length()) return t.length() -j;
        if(j == t.length()) return s.length() -i;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] =  solver(i+1 , j+1 , s , t , dp);
        }
        int insert = solver(i , j+1 , s , t,dp);
        int delete = solver(i+1 , j , s , t,dp);
        int replace = solver(i+1 , j+1 , s ,t,dp);

        return dp[i][j] = 1+ Math.min(insert,Math.min(delete , replace));

    }
}