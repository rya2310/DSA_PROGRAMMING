class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0] == c){
                st.peek()[1]++;

                if(st.peek()[1] == k){
                    st.pop();
                }
            }else{
                st.push(new int[]{c,1});
            }
        }

        StringBuilder res = new StringBuilder();
        for(int[] i : st){
            char ch = (char) i[0];
            int cnt = i[1];

            for(int x = 0 ; x < cnt ; x++){
                res.append(ch);
            }
        }
        return res.toString();
    }
}