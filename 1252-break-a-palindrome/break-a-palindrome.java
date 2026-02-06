class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        char[] c = palindrome.toCharArray();
        int n = c.length;
        for(int i = 0 ; i < n/2 ; i++){
            if(c[i] != 'a'){
                c[i] = 'a';
                return String.valueOf(c);
            }
        }
        c[n-1] = 'b';
        return String.valueOf(c);
    }
}