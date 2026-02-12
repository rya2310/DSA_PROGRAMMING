class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] narr = new int[m + n];
        int left = 0, right = 0, idx = 0;

        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                narr[idx++] = nums1[left++];
            } else {
                narr[idx++] = nums2[right++];
            }
        }

        while(left < m){
            narr[idx++] = nums1[left++];
        }

        while(right < n){
            narr[idx++] = nums2[right++];
        }
        for(int i = 0; i < m+n; i++){
            nums1[i] = narr[i];
        }
    }
}
