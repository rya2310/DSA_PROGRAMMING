class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int cnt = 0;
        for(int i = 0 ; i < sentence.length() ; i++){
            
            int idx = sentence.charAt(i) - 'a';
            if(arr[idx] == 0){
                arr[idx]++;
                cnt++;
            }
            if(cnt == 26) return true;
        }
        return false;
    }
}