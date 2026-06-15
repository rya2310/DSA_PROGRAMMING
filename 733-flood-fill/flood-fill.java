class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(image, sr, sc,color, original);

        return image;
    }

    void dfs(int[][] image , int i , int j , int nc , int oc){
        int m = image.length;
        int n = image[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] == nc || image[i][j] != oc) {
            return;
        }
        image[i][j] = nc;

        dfs(image , i-1 , j , nc , oc);
        dfs(image , i+1 , j , nc , oc);
        dfs(image , i , j-1 , nc , oc);
        dfs(image , i , j+1 , nc , oc);
    }
}