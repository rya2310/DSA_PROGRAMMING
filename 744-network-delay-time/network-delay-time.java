class Pair{
    int weight;
    int node;
    Pair(int w , int n){
        this.weight = w;
        this.node = n;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : times){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(w,v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        int[] d = new int[n+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[k] = 0;

        pq.offer(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int curr_wt = curr.weight;
            int curr_node = curr.node;
            for(Pair neigh : adj.get(curr_node)){
                int neigh_wt = neigh.weight;
                int neigh_node = neigh.node;
                if(neigh_wt + curr_wt < d[neigh_node]){
                    d[neigh_node] = neigh_wt + curr_wt;
                    pq.offer(new Pair(d[neigh_node] , neigh_node));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < d.length ; i++){
            if(d[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max , d[i]);
        }
        return max;
    }
}