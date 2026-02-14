class Solution {

    Integer[][] dp;

    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);

        for(int c : cuts) arr.add(c);

        arr.add(n);

        dp = new Integer[arr.size()][arr.size()];

        return solver(0, arr.size()-1, arr);
    }

    public int solver(int l, int r, ArrayList<Integer> arr){

        if(r - l <= 1) return 0;

        if(dp[l][r] != null) return dp[l][r];

        int result = Integer.MAX_VALUE;

        for(int i = l + 1; i < r; i++){

            int cost = (arr.get(r) - arr.get(l))
                       + solver(l, i, arr)
                       + solver(i, r, arr);

            result = Math.min(result, cost);
        }

        return dp[l][r] = result;
    }
}
