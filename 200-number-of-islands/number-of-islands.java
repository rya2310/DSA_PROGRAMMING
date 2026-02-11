class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void bfs(int r , int c , char[][] grid, int[][] vis){

    vis[r][c] = 1;

    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(r,c));

    int n = grid.length;
    int m = grid[0].length;

    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};

    while(!q.isEmpty()){

        int row = q.peek().first;
        int col = q.peek().second;
        q.remove();

        for(int k = 0; k < 4; k++){

            int nrow = row + dr[k];
            int ncol = col + dc[k];

            if(nrow >= 0 && nrow < n &&
               ncol >= 0 && ncol < m &&
               grid[nrow][ncol] == '1' &&
               vis[nrow][ncol] == 0){

                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow , ncol));
            }
        }
    }
}

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0 ; 
        int[][] visited = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i , j , grid , visited);
                }
            }
        }
        return cnt;
    }

    // public void bfs()
}