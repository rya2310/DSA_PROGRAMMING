class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for(int i = 1 ; i <= n ;i++){
            st.push(i);
            ans.add("Push");

            if(st.peek() == target[j]){
                j++;
            }else{
                st.pop();
                ans.add("Pop");
            }
            if(j == target.length) return ans;
        }
        return ans;
    }
}