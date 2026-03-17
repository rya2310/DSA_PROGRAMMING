class NumArray {
    int[] segment;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segment = new int[4*n];
        buildSegmentTree(0 , 0 , n-1 , nums);
    }
    
    public int sumRange(int left, int right) {
        return Query(0 , n-1 , left , right , 0);
    }

    public void buildSegmentTree(int i , int left , int right , int[] nums){
        if(left == right){
            segment[i] = nums[right];
            return;
        }
        int mid = (left+right)/2;
        buildSegmentTree(2*i+1 , left , mid , nums);
        buildSegmentTree(2*i+2 , mid+1 , right , nums);
        segment[i] = segment[2*i+1] + segment[2*i+2];

    }

    public int Query(int s , int e , int l , int r , int i){
        if(l > e || r < s) return 0;
        if(s >= l && e <= r) return segment[i];
        int mid = (s+e)/2;
        return Query(s, mid, l, r, 2*i+1) +
           Query(mid+1, e, l, r, 2*i+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */