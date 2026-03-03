class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1 && k == 1) return '0';

        int len = (1 << n) -1;
        int mid = (len/2) + 1;

        if(k == mid) return '1';

        return (char) (helper(n,k)+'0');
    }

    public int helper(int n , int k){
        if(n == 1) return 0;

        int len = (1 << n) - 1;
        int mid = (len / 2) + 1;

        if(k == mid) return 1;

        if( k < mid){
            return helper(n-1 , k);
        }

        int mirror  = (len - k +1);
        int val = helper(n-1 , mirror);

        return val == 0 ? 1 : 0;
    }
}