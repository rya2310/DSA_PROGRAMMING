class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // size 0 rhombus
                set.add(grid[i][j]);

                for (int k = 1; ; k++) {

                    int r = i + 2 * k;
                    int left = j - k;
                    int right = j + k;

                    if (r >= m || left < 0 || right >= n) break;

                    int sum = 0;

                    int x = i, y = j;

                    // top -> right
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + t][y + t];
                    }

                    // right -> bottom
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + k + t][y + k - t];
                    }

                    // bottom -> left
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + 2 * k - t][y - t];
                    }

                    // left -> top
                    for (int t = 0; t < k; t++) {
                        sum += grid[x + k - t][y - k + t];
                    }

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int idx = 0;
        Iterator<Integer> it = set.descendingIterator();
        while (it.hasNext() && idx < 3) {
            ans[idx++] = it.next();
        }

        return ans;
    }
}