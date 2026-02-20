class Solution {
    public int majorityElement(int[] nums) {
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 0;
        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[j] == nums[i]) {
        //             count++;
        //         }
        //     }
        //     if (count > nums.length / 2) {
        //         return nums[i];
        //     }
        // }
        // return -1; // majority element always exists per problem constraint

        //Second Method
        // HashMap<Integer, Integer> hashMap = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     int val = nums[i];
        //     hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        //     if (entry.getValue() > nums.length / 2) {
        //         return entry.getKey();
        //     }
        // }

        // return -1;

        //KeySet Method

        // int n = nums.length;
        // Map<Integer , Integer> map = new HashMap<>();
        // for(int i = 0 ; i < n ; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        // }

        // for(int key : map.keySet()){
        //     if(map.get(key) > n/2){
        //         return key;
        //     }
        // }
        // return -1;

        //Moore Voting Algorithm
        int cand = 0;
        int cnt = 0;

        for(int num : nums){
            if(cnt== 0){
                cand = num;
            }
            if(cand == num){
                cnt++;
            }else{
                cnt--;
            }
        }

        cnt = 0;

        for(int num : nums){
            if(num == cand){
                cnt++;
            }
        }

        if(cnt > nums.length/2){
            return cand;
        }
        return -1;
    }
}
