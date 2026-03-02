class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trail = new int[grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            int cnt = 0;
            for(int j = (grid[0].length)-1 ; j >= 0 ; j--){
                if(grid[i][j] == 0){
                    cnt++;
                }else{
                    break;  
                }
                
            }
            trail[i] = cnt;
            // System.out.print(trail[i]+" ");
        }

        int swaps = 0;
         
        for(int i = 0 ; i < n ; i++){
            int need = n-i-1;
            int j = i;
            while(j < n && trail[j] < need){
                j++;
            }
            if(j == n) return -1;

            while(j > i){
                int temp = trail[j];
                trail[j] = trail[j-1];
                trail[j-1] = temp;
                swaps++;
                j--;
            }
        }
        return swaps ;
    }
}

//Number of Swaps (distance)
//distance between both the index(dest - src)