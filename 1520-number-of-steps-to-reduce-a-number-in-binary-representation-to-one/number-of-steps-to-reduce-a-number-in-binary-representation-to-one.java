import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {

        BigInteger num = new BigInteger(s, 2);
        BigInteger TWO = BigInteger.valueOf(2);

        int cnt = 0;

        while(num.compareTo(BigInteger.ONE) > 0){

            if(num.mod(TWO).equals(BigInteger.ZERO)){
                num = num.divide(TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }

            cnt++;
        }

        return cnt;
    }
}