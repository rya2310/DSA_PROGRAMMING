class Solution {
    public String makeLargestSpecial(String s) {
        
        if(s.isEmpty()) return "";

        int cnt = 0;
        int start = 0;
        List<String> specialString = new ArrayList<>();

        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '1'){
                cnt++;
            }else{
                cnt--;
            }

            //Equal number of 0's and 1's
            if(cnt == 0){
                String inner = makeLargestSpecial(s.substring(start+1 , i));
                specialString.add("1"+inner+"0");
                start = i + 1;
            }
        }

        Collections.sort(specialString , Collections.reverseOrder()) ;

        StringBuilder str = new StringBuilder();
        for(String x : specialString){
            str.append(x);
        }

        return str.toString();
    }
}