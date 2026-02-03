class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < m ; j++){
                int temp = matrix[i][j];
                matrix[i][j]  = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0 ; i < m ; i++){
            reverse(matrix[i]);
        }
    }
    
    public void reverse(int[] row){
        int i = 0 ;
        int j = row.length-1;
        while(i < j){
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }
}