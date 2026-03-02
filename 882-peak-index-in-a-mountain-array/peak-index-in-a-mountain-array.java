class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int j = 0 ;
        while(arr[j]< arr[j+1]){
            j++;
        }
        return j;
    }
}