class Solution {
    public String getHappyString(int n, int k) {
        List<String> ls=new ArrayList<>();
        solve(0,n,new StringBuilder(),ls);
        Collections.sort(ls);
        System.out.println(ls);
        if(k>ls.size()) return "";
        return ls.get(k-1);
    }
    public void solve(int idx,int n,StringBuilder curr,List<String> list){
        if(idx==n){
            list.add(curr.toString());
            return ;
        }
        for(char a='a';a<='c';a++){
            if(curr.length()>0 && a==curr.charAt(curr.length()-1)) continue;
            curr.append(a);
            solve(idx+1,n,curr,list);
            curr.deleteCharAt(curr.length()-1);
        }

    }
}