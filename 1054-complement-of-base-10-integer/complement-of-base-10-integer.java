class Solution {
    public int bitwiseComplement(int n) {
        // if(n <= 1) return 1-n;
        // if((n+1 & n) == 0)return 0;

        int k = (int)(Math.log(n)/Math.log(2))+1;
        int ans = (1<<k)-1;
        return ans^n;
    }
}