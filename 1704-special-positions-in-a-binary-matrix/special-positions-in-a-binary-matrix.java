class Solution {
    public int numSpecial(int[][] mat) {
     int cnt=0;

     for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat[0].length;j++){

            if(mat[i][j]==1 && good(i,j,mat)) cnt++;
        }
     }   
     return cnt;
    }

    public boolean good(int r,int c,int[][] mat){

        //row
        for(int i=0;i<mat[0].length;i++){
            if(i==c) continue;
            if(mat[r][i]==1) return false;
        }

        for(int j=0;j<mat.length;j++){
            if(j==r) continue;
            if(mat[j][c]==1) return false;
        }

        return true;
    }
}