class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int i = 0;
        int j = n-1;
        int boat = 0;
        int minBoat = Integer.MAX_VALUE;
        Arrays.sort(people);
        while(i <= j){
            if(people[i] + people[j] <= limit){
                boat++;
                // minBoat = Math.min(boat , minBoat);
                i++;
                j--;
            }else{
                boat++;
                j--;
            }
        }
        return boat;
    }
}