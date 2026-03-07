class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s+s;
        int l = 0;
        int j = 0;

        StringBuilder s1 = new StringBuilder() , s2 = new StringBuilder() ;
        for(int i = 0 ; i < 2*n ; i++){
            s1.append(i%2 == 0 ? '0' : '1');
            s2.append(i%2 == 0 ? '1' : '0');
        }

        int res = Integer.MAX_VALUE;
        int f1 = 0;
        int f2 = 0;

        while(j < 2*n){
            if(s.charAt(j) != s1.charAt(j)) f1++;
            if(s.charAt(j) != s2.charAt(j)) f2++;
            
            if(j-l+1 > n){
                if(s.charAt(l) != s1.charAt(l)) f1--;
                if(s.charAt(l) != s2.charAt(l)) f2--;
                l++;
                res = Math.min(res,Math.min(f1,f2));
            }
            j++;   
        }   
        return res;
    }
    
}