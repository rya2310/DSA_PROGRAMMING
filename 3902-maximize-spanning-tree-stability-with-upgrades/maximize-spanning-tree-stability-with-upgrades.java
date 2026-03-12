class DSU {
    int[] parent;
    int[] rank;
    int components;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        if (rank[pa] < rank[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;

        if (rank[pa] == rank[pb]) {
            rank[pa]++;
        }

        components--;
        return true;
    }
}
class Solution {
    public int maxStability(int n, int[][] edges, int k) {
       
       DSU dsu=new DSU(n);
       for(int[] e: edges){
        if(e[3]==1 && !dsu.union(e[0],e[1])) return -1;
       }
       int s=1;
       int e=200000;
       int ans=-1;
       while(s<=e){
        int m=s+(e-s)/2;
        if(pos(m,edges,k,n)){
            ans=m;
            s=m+1;
        }else{
            e=m-1;
        }
       }

       return ans;

    }

  
    public boolean pos(int mt,int[][] edges,int k,int n){
       DSU dsu=new DSU(n);

       int mine=Integer.MAX_VALUE;
       for(int[] e: edges){
        if(e[3]==1){

            if(e[2]<mt) return false;
            if(!dsu.union(e[0],e[1])) return false;
            mine=Math.min(mine,e[2]);
        }
       }

       for(int[] e: edges){
            if(e[3]==1) continue;
            if(e[2]>=mt) {
                dsu.union(e[0],e[1]);
            }
        }

        for(int[] e: edges){

            if(e[3]==0 && e[2]<mt && 2*e[2]>=mt){
                if(dsu.union(e[0],e[1])){
                    k--;
                    if(k<0) return false;
                }
            }
        }
        return dsu.components==1;

       }


    
}