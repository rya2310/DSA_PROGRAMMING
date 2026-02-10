class Solution {

    public int longestBalanced(int[] nums) {

        int n = nums.length;
        int maxLen = 0;

        for(int left = 0; left < n; left++) {

            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            for(int right = left; right < n; right++) {

                if(nums[right] % 2 == 0) {
                    evenSet.add(nums[right]);
                } else {
                    oddSet.add(nums[right]);
                }

                if(evenSet.size() == oddSet.size()) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
        }

        return maxLen;
    }
}
