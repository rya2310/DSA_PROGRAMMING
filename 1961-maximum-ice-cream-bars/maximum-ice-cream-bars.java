class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int iceBars = 0;
        for(int i = 0 ; i < costs.length ;i++){
            if(coins - costs[i] >= 0){
                iceBars++;
                coins = coins - costs[i];
            }
        }
        return iceBars;
    }
}