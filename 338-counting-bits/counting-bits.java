class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        // if(n == 0) return result;

        // result[0] = 0;

        // for(int i = 2 ; i <= n ; i++){
        //     if(i/2 != 0){
        //         result[i] = result[i/2]+1;
        //     }else{
        //         result[i] = result[i/2];
        //     }
        // }
        // return result;

        while(n >= 0){
            int cnt = 0;
            int i = n;
            while(i > 0){
                
                if(i % 2 != 0) cnt++;
                i /= 2;
            }

            result[n] = cnt;
            n--;
        }
        return result;
    }
}