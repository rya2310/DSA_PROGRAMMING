class Solution {
    public String intToRoman(int num) {
        String res = "";
        int[] value = {1000 , 900 , 500,400 , 100,90 , 50,40 , 10,9 , 5,4, 1};
        String[] val = {"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"} ;
        while(num > 0){
            int t = 0;
            for(int i = 0 ; i < val.length ; i++){
                if(num < value[i]) continue;
                t = num / value[i] ;
                num = num % value[i] ;

                for(int x = 0 ; x<t ; x++){
                    res += val[i];
                }
            }
        }
        return res;
    }
}