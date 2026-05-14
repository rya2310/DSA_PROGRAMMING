class Tuple{
    int weight;
    int row;
    int col;
    Tuple(int w , int r , int c){
        this.weight = w;
        this.row = r;
        this.col = c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b) -> a.weight-b.weight);
        int[][] d = new int[n][m];
        for(int[] i : d){
            Arrays.fill( i , Integer.MAX_VALUE);
        }
        d[0][0] = 0;

        pq.offer(new Tuple(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int currdist = curr.weight;
            int currrow = curr.row;
            int currcol = curr.col;

            if(currrow == n-1 && currcol == m-1) return currdist;
            for(int i =0 ; i < 4 ; i++){
                int adjrow = currrow + dr[i];
                int adjcol = currcol + dc[i];

                if(adjrow >= 0 && adjcol >= 0 && adjrow < n && adjcol < m){
                    int effort = Math.max(Math.abs(heights[currrow][currcol] - heights[adjrow][adjcol]) , currdist);
                    if(effort < d[adjrow][adjcol]){
                        d[adjrow][adjcol] = effort;
                        pq.offer(new Tuple(effort , adjrow , adjcol));
                    }
                }
            }
        }
        return 0;
    }
}