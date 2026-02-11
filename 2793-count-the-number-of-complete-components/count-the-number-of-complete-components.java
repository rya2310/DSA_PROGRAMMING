class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int complete = 0;

        for(int i = 0; i < n; i++) {

            if(!visited[i]) {

                List<Integer> comp = new ArrayList<>();

                dfs(i, graph, visited, comp);

                int size = comp.size();
                boolean isComplete = true;

                for(int node : comp) {
                    if(graph.get(node).size() != size - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if(isComplete) complete++;
            }
        }

        return complete;
    }

    private void dfs(int node,
                     List<List<Integer>> graph,
                     boolean[] visited,
                     List<Integer> comp) {

        visited[node] = true;
        comp.add(node);

        for(int nei : graph.get(node)) {
            if(!visited[nei]) {
                dfs(nei, graph, visited, comp);
            }
        }
    }
}
