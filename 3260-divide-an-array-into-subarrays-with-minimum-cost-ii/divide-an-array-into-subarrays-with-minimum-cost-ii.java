class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int need = k - 2;
        long ans = Long.MAX_VALUE;

        TreeSet<Integer> l = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return nums[a] - nums[b];
            return a - b;
        });

        TreeSet<Integer> r = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return nums[a] - nums[b];
            return a - b;
        });

        long sum = 0;

        for (int j = 2; j <= Math.min(n - 1, 1 + dist); j++) {
            r.add(j);
        }

        while (l.size() < need && !r.isEmpty()) {
            int idx = r.pollFirst();
            l.add(idx);
            sum += nums[idx];
        }

        if (l.size() == need) {
            ans = Math.min(ans, nums[0] + nums[1] + sum);
        }

        for (int i = 2; i < n; i++) {

            if (l.remove(i)) {
                sum -= nums[i];
            } else {
                r.remove(i);
            }

            int in = i + dist;
            if (in < n) {
                if (!l.isEmpty() && nums[in] < nums[l.last()]) {
                    int move = l.pollLast();
                    sum -= nums[move];
                    r.add(move);

                    l.add(in);
                    sum += nums[in];
                } else {
                    r.add(in);
                }
            }

            while (l.size() < need && !r.isEmpty()) {
                int move = r.pollFirst();
                l.add(move);
                sum += nums[move];
            }

            if (l.size() == need) {
                ans = Math.min(ans, nums[0] + nums[i] + sum);
            }
        }

        return ans;
    }
}