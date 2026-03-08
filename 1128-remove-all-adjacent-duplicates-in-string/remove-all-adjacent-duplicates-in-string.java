class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            if(st.isEmpty() || st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
                continue;
            }

            st.pop();
        }
        StringBuilder s1 = new StringBuilder();
        while(!st.isEmpty()){
            s1.append(st.pop());
        }
        return s1.reverse().toString();
    }
}