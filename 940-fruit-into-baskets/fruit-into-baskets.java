class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer , Integer> f = new HashMap<>();

        for(int high = 0 ; high < n ; high++){
            //S1
            int i = fruits[high];
            f.put(i , f.getOrDefault(i,0)+1);

            //S2
            while(f.size() > 2){
                int li = fruits[low];
                f.put(li , f.getOrDefault(li,0)-1);
                if(f.get(li) == 0){
                    f.remove(li);
                }
                low++;
            }
            if(f.size() == 2){
                max = Math.max(max , high-low+1);
            }
        }
        return max==Integer.MIN_VALUE?n:max;
    }
}