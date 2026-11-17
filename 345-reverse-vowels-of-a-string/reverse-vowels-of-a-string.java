class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();

        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(!isVowel(c[i])){
                i++;
            } else if(!isVowel(c[j])){
                j--;
            } else {
                swap(c , i , j);
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }

    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
                return true;
            }
        return false;
    }
    public void swap(char[] c , int a , int b){
        char temp = c[a] ; 
        c[a] = c[b] ;
        c[b] = temp ;
    } 
}