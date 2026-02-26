class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int cnt = 0;
        for(int i = 0 ; i < nums.length ; i++){
             sum += nums[i];
            int q = sum-k;
            if(map.containsKey(q)){
                cnt += map.get(q);
            }
            map.put(sum , map.getOrDefault(sum , 0)+1);
        }
        return cnt;
    }
}