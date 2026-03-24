class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][] pre=new long[n][m];
        long[][] suf=new long[n][m];
        for(int i=0;i<n;i++){
            pre[i][0]=grid[i][0];
            for(int j=1;j<m;j++){
                pre[i][j]=(pre[i][j-1]*(long)grid[i][j])%12345;
            }
        }
                for(int i=0;i<n;i++){
            suf[i][m-1]=grid[i][m-1];
            for(int j=m-2;j>=0;j--){
                suf[i][j]=(suf[i][j+1]*(long)grid[i][j])%12345;
            }
        }
        // System.out.println(Arrays.deepToString(pre));
        // System.out.println(Arrays.deepToString(suf));
        long[] down=new long[n];
        down[n-1]=pre[n-1][m-1];
        for(int i=n-2;i>=0;i--){
            down[i]=(down[i+1]*pre[i][m-1])%12345;
        }
        int[][] ans=new int[n][m];
        long total=1;
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){

                long premul=j>0?pre[i][j-1]:1;
                long sufmul=j<m-1?suf[i][j+1]:1;
                // System.out.println("premul: "+premul+" sufm: "+sufmul+" total: "+total+" down: "+(i<n-1?down[i+1]:1));
                ans[i][j]=(int)(((total*(i<n-1?down[i+1]:1))%12345)*((premul*sufmul)%12345))%12345;
                
            }
            total=(total*pre[i][m-1])%12345;
        }
        return ans;
    }
}