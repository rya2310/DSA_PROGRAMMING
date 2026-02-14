class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int n=query_row;
       double[][] dp=new double[n+1][n+1];

       dp[0][0]=poured;
       for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                
                double back=0;
                double up=0;
                if(j>0 && dp[i-1][j-1]>1.0){
                    back=(dp[i-1][j-1]-1)/(double)2;
                }
                if(dp[i-1][j]>1.0){
                    up=(dp[i-1][j]-1)/(double)2;
                }
                // System.out.println("back: "+back+" up: "+up);
                dp[i][j]=back+up;
            }
       } 
    //    for(double[] e: dp) System.out.println(Arrays.toString(e));
       return Math.min(1,dp[n][query_glass]);
    }
}