class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(int i = 0 ; i < sentence.length() ; i++){
            int idx = sentence.charAt(i) - 'a';
            arr[idx] = arr[idx] + 1;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] == 0) return false;
        }
        return true;
    }
}