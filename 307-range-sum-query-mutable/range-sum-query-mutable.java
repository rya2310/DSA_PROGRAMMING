class NumArray {
    int[] segment;
    int n ;
    // int[] lazy;

    public NumArray(int[] nums) {
        n = nums.length;
        segment = new int[4*n];
        // lazy = new int[4*n];
        // for(int i = 0 ; i < lazy.length; i++){
        //     lazy[i] = 0;
        // }

        buildSegmentTree(0 , n-1 , 0 , nums);
    }
    
    public void update(int index, int val) {
        up(0 , n-1 , 0 , index , val);
    }

    public void up(int l , int r , int i , int idx , int val){
        if(l == r){
            segment[i] = val;
            return;
        }
        int mid = (l + r)/2;
        if(idx <= mid){
            //left
            up(l , mid , 2*i+1 , idx , val);
        }else{
            //right
            up(mid+1 , r , 2*i+2 , idx , val);
        }
        segment[i] = segment[2*i+1] + segment[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        return query(0 , n-1 , left , right , 0);
    }

    public int query(int s , int e , int l , int r , int i){
        if(r < s || l > e) return 0;
        if(l <= s && e <= r){
            return segment[i];
        }
        int mid = (s+e)/2;
        return query(s,mid , l , r , 2*i+1) + query(mid+1 , e , l , r , 2*i+2);
    }

    public void buildSegmentTree(int left , int right , int i , int[] nums){
        if(left == right){
            segment[i] = nums[left];
            return;
        }
        int mid = (left + right)/2;
        //left segment
        buildSegmentTree(left , mid , 2*i+1 , nums);
        //right segment
        buildSegmentTree(mid+1 , right , 2*i+2 , nums);
        //update value present in segment;
        segment[i] = segment[2*i+1]+segment[2*i+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */