class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cm = 1;
        int off = 1;

        while(cm < n){
            if(nums[cm] == nums[cm-1]){
                cm++;
                continue;
            }else{
                nums[off] = nums[cm];
                off++ ;
                cm++;
            }
        }
        return off;
    }
}