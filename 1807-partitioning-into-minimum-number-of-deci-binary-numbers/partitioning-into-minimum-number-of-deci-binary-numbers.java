class Solution {
    public int minPartitions(String n) {
        // int num = 
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n.length() ; i++){
            char c = n.charAt(i);
            max = Math.max(max , c - '0');
        }
        return max;
    }
}