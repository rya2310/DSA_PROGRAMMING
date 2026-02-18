class Solution {
    public boolean hasAlternatingBits(int n) {
        String b = Integer.toBinaryString(n);

        for(int i = 1 ; i < b.length() ;i++){
            if(b.charAt(i) == b.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}