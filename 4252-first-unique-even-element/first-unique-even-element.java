class Solution {
    public int firstUniqueEven(int[] nums) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] % 2 == 0){
        //         map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        //     }
        // }

        // for(int i= 0 ; i < nums.length ; i++){
        //     if(map.containsKey(nums[i])){
        //         if(map.get(nums[i]) == 1){
        //             return nums[i];
        //         }
        //     }
        // }
        // return -1;

        int[] freq = new int[101];
        for(int i : nums) if(i%2 == 0) freq[i]++;
        for(int i : nums) if(i%2 == 0 && freq[i] == 1) return i;
        return -1;
    }
}