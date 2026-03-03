class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        int low = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int high = 0; high < nums.length; high++){

            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            while(map.size() > k){
                int leftVal = nums[low];
                map.put(leftVal, map.get(leftVal) - 1);

                if(map.get(leftVal) == 0){
                    map.remove(leftVal);
                }

                low++;
            }

            res += (high - low + 1);
        }

        return res;
    }
}