class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        
        int i = 0 ;
        int j = tokens.length-1;
        int score = 0;
        int maxScore = 0;
        while(i <= j){
            if(power >= tokens[i]){
                power -= tokens[i];
                score ++;
                maxScore = Math.max(maxScore , score);
                i++;
            } else if(score >= 1){
                power += tokens[j];
                score -= 1;
                j--;
            }else{
                break;
            }
        }
    
        return maxScore;
    }
}