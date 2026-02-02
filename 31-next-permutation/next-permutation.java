class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // 1️⃣ Find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }

        // 2️⃣ If pivot exists, swap with next greater
        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, pivot, i);
                    break;
                }
            }
        }

        // 3️⃣ Reverse suffix
        reverse(pivot + 1, n - 1, nums);
    }

    // Swap array elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse subarray
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
