class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
            
        for (int i = num1; i <= num2; i++) {
             String s=String.valueOf(i);
            if(s.length()<=2)continue;
            for(int j=1;j<s.length()-1;j++){
                int p=s.charAt(j-1)-'0';
                int c=s.charAt(j)-'0';
                int f=s.charAt(j+1)-'0';
                if((p<c && c>f) || (p>c && f>c)) count++;
            }
        }
        return count;
    }
}