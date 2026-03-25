class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        long totalSum = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                totalSum += grid[i][j];

                rowSum[i] += grid[i][j];

                colSum[j] += grid[i][j];
            }
        }
        if(totalSum % 2 != 0) return false;

        long upp = 0;
        for(int i = 0 ; i < m-1 ; i++){
            upp += rowSum[i]; 
            if(upp == totalSum- upp) return true;
        }

        long left = 0;
        for(int j = 0 ; j < n-1 ; j++){
            left += colSum[j];
            if(left == totalSum-left) return true;
        }
        return false;
    }
}