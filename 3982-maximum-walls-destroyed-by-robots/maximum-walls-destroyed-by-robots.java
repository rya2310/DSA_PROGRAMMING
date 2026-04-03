import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        Arrays.sort(walls);

        int[][] rb = new int[n][2];
        for (int i = 0; i < n; i++) {
            rb[i][0] = robots[i];
            rb[i][1] = distance[i];
        }
        Arrays.sort(rb, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] dp = new int[n][2];

        int[][] left = new int[n][2];
        int[][] right = new int[n][2];

        for (int i = 0; i < n; i++) {
            int l = rb[i][0] - rb[i][1];
            if (i > 0) l = Math.max(l, rb[i-1][0] + 1);
            left[i] = new int[]{l, rb[i][0]};

            int r = rb[i][0] + rb[i][1];
            if (i < n - 1) r = Math.min(r, rb[i+1][0] - 1);
            right[i] = new int[]{rb[i][0], r};
        }

        dp[0][0] = count(walls, left[0][0], left[0][1]);
        dp[0][1] = count(walls, right[0][0], right[0][1]);

        for (int i = 1; i < n; i++) {

            int wallsLeft = count(walls, left[i][0], left[i][1]);
            int wallsRight = count(walls, right[i][0], right[i][1]);

            // LEFT
            int noOverlap = dp[i-1][0] + wallsLeft;

            int overlap = overlap(walls,
                    right[i-1][0], right[i-1][1],
                    left[i][0], left[i][1]);

            int withOverlapFix = dp[i-1][1] + wallsLeft - overlap;

            dp[i][0] = Math.max(noOverlap, withOverlapFix);

            // RIGHT (always safe)
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + wallsRight;
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    private int overlap(int[] walls, int l1, int r1, int l2, int r2) {
        int l = Math.max(l1, l2);
        int r = Math.min(r1, r2);
        return count(walls, l, r);
    }

    private int count(int[] walls, int l, int r) {
        if (l > r) return 0;
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);
        return Math.max(0, right - left);
    }

    private int lowerBound(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= val) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > val) r = m;
            else l = m + 1;
        }
        return l;
    }
}