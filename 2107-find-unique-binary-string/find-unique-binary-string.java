class Solution {
    static String res;
    public String findDifferentBinaryString(String[] nums) {
       Set<String> set=new HashSet<>();
       for(String e: nums) set.add(e); 
       solve(0,nums.length,set,new StringBuilder());
       return res;
    }
    public boolean solve(int idx,int n,Set<String> set,StringBuilder curr){
        if(idx==n){
            String t=curr.toString();
            if(!set.contains(t)){
                res=t;
                return true;
            }
            return false;
        }
        curr.append('0');
        boolean f=solve(idx+1,n,set,curr);
        curr.deleteCharAt(curr.length()-1);
        if(f) return true;

        curr.append('1');
        boolean s=solve(idx+1,n,set,curr);
        curr.deleteCharAt(curr.length()-1);
        return s;
    }
}