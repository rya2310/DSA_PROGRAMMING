class Solution {
    public int pivotIndex(int[] nums) {
    //     int n = nums.length;

    //     int totalSum = nums[0];
    //     for(int t = 1 ; t < n ; t++){
    //         totalSum += nums[t]; 
    //     }

    //     int leftSum = 0;

    //     for(int i = 0 ; i < n ; i++){
    //         int rightSum = totalSum - leftSum - nums[i];

    //         if(rightSum == leftSum){
    //             return i;
    //         }

    //         leftSum += nums[i];
    //     }

    //     return -1;

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 0;
        suffix[n-1] = 0;
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
            System.out.print(prefix[i]+" ");
        }
        System.out.println();
        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = suffix[i+1]+nums[i+1];
            System.out.print(suffix[i]+" ");
        }

        for(int i = 0 ; i < n ; i++){
            if(suffix[i] == prefix[i]) return i;
        }

        return -1;
    }
}