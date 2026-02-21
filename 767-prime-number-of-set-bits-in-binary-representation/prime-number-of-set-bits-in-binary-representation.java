class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left ; i <= right ; i++){
            int c = cnt(i);
            if(prime(c)){
                count++;
            }
        }

        return count;
    }

    public int cnt(int num){
        int count = 0;
        while(num > 0){
            if(num % 2 != 0) count++;
                num /= 2;
        }
        return count;
    }

    public boolean prime(int num){
        if(num <= 1) return false;

        for(int i = 2 ; i < num ; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}