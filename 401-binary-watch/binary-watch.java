class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<=59;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    res.add(i+":"+(j<10?"0":"")+j);
                }
            }
        }
        return res;
    }
}