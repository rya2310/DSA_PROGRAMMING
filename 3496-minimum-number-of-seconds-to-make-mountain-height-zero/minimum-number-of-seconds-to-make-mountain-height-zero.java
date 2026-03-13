class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while(left <= right){

            long mid = left + (right - left) / 2;

            if(check(mid, mountainHeight, workerTimes)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean check(long mid, int mh, int[] w){

        long h = 0;

        for(int t : w){

            long k = (long)((Math.sqrt(1 + (8.0 * mid) / t) - 1) / 2);

            h += k;

            if(h >= mh) return true;
        }

        return false;
    }
}