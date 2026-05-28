class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int n = strs.length;
        Arrays.sort(strs);
        String first = strs[0];
        String end = strs[n-1];
        
        int i = 0;

        while(i < first.length() && i < end.length() && first.charAt(i) == end.charAt(i)){
            i++;
        }

        return first.substring(0,i);
    }
}