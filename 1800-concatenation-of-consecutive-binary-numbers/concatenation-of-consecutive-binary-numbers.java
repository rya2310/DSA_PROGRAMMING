class Solution {
    public int concatenatedBinary(int n) {
        int M = 1_000_000_007;
        long result = 0;
        for(int i = 1 ; i <= n ; i++){
            int digit = (int)(Math.log(i) / Math.log(2)) + 1;
            result = ((result << digit)%M + i)%M;
        }
        return (int)result;
    }
}