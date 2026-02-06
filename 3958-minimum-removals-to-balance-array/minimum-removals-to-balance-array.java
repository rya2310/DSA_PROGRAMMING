class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.sort(nums);
        int i = 0 ; 
        int j = 1;
        int minCount = Integer.MAX_VALUE;
        int l = 0;
        // ArrayList<Integer> arr = new ArrayList<>();
        while(i < n-1 &&  j < n){
            if((long)nums[i]*(long)k >= (long)nums[j]){
                l =  n-1 - j + i ;
                minCount = Math.min(minCount , l);
                j++;
            }else if(nums[i]*k < nums[j]){
                i++;
                
            }
        }
        return (minCount == Integer.MAX_VALUE)?1:minCount;
    }
}