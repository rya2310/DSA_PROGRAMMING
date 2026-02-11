class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max = 0 ; 

        for(int i = 0 ; i < n ; i++){
            Set<Integer> oset = new HashSet<>();
            Set<Integer> eset = new HashSet<>();
            
            for(int j = i ; j < n ; j++){
            
                if(nums[j] % 2 == 0){
                    eset.add(nums[j]);
                }else{
                    oset.add(nums[j]);
                }

                if(oset.size() == eset.size()){
                    max = Math.max(max , j-i+1);
                }
            }
        }
        return max;
    }
}