class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length() ;
        int low = 0;
        int[] f = new int[256];
        int res = Integer.MIN_VALUE;
        for(int high = 0; high < n; high++){
            f[s.charAt(high)]++;

            int max = find(f);
            int len = high-low+1;
            int diff = len - max;

            while(diff > k){
                f[s.charAt(low)]--;
                low++;

                max = find(f);
                len = high-low+1;
                diff = len - max;
            }

            len = high-low+1;
            res = Math.max(res,len);
        }
        return res;
    }

    public int find(int[] a){
        int maxi = -1;
        for(int i = 0 ;i < 256 ;i++){
            maxi = Math.max(maxi , a[i]);
        }
        return maxi;
    }
}