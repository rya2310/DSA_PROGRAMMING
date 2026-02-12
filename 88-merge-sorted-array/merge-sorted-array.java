class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] narr = new int[n+m];
        int left = 0;
        int right= 0;

        int idx = 0;

        while(left < m && right < n){
            if(nums1[left] >= nums2[right]){
                narr[idx] = nums1[left];
                left++;
                idx++;
            }else{
                narr[idx] = nums2[right];
                idx++;
                right++;
            }
        }

        while(left < m){
            narr[idx++] = nums1[left++];
        }

        while(right < n){
            narr[idx++] = nums2[right++];
        }
        Arrays.sort(narr);
        for(int i = 0; i < m+n; i++){
            nums1[i] = narr[i];
        }
        
    }
}