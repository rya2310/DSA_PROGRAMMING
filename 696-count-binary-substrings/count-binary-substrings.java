class Solution {
    public int countBinarySubstrings(String s) {
        int curr_cnt = 1;
        int prev_cnt = 0;

        int cnt = 0 ;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curr_cnt++;
            }else{
                cnt += Math.min(curr_cnt , prev_cnt);
                prev_cnt = curr_cnt;
                curr_cnt = 1;
            }
        }
        cnt += Math.min(prev_cnt , curr_cnt);
        return cnt;
    }
}