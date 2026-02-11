class Segment {

    class Node {
        int mn;
        int mx;
        int lazy;

        Node(int x, int n, int lazy) {
            this.mn = x;
            this.mx = n;
            this.lazy = lazy;
        }
    }

    Node[] seg;
    int n = 0;

    Segment(int n, int[] arr) {
        this.seg = new Node[4 * n];
        this.n = n;
        for (int i = 0; i < 4 * n; i++) {
            seg[i] = new Node(0, 0, 0);
        }

        build(0, 0, n - 1, arr);
    }

    void pull(int v) {
        seg[v].mn = Math.min(seg[2 * v + 1].mn, seg[2 * v + 2].mn);
        seg[v].mx = Math.max(seg[2 * v + 1].mx, seg[2 * v + 2].mx);
    }

    void applyLazy(int v, int x) {
        seg[v].mn += x;
        seg[v].mx += x;
        seg[v].lazy += x;
    }

    void push(int v) {
        if (seg[v].lazy != 0) {
            applyLazy(2 * v + 1, seg[v].lazy);
            applyLazy(2 * v + 2, seg[v].lazy);
            seg[v].lazy = 0;
        }
    }

    //build
    void build(int node, int l, int r, int[] a) {
        if (l == r) {
            seg[node].mn = a[l];
            seg[node].mx = a[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node + 1, l, mid, a);
        build(2 * node + 2, mid + 1, r, a);
        pull(node);
    }

    void addRange(int st, int end, int node, int l, int r, int x) {
        if (r < st || end < l)
            return;
        if (st <= l && r <= end) {
            applyLazy(node, x);
            return;
        }
        push(node);
        int mid = l + (r - l) / 2;
        addRange(st, end, 2 * node + 1, l, mid, x);
        addRange(st, end, 2 * node + 2, mid + 1, r, x);
        pull(node);
    }

    int queryRange(int node, int l, int r) {
        if (seg[node].mn > 0 || seg[node].mx < 0)
            return -1;
        if (l == r)
            return l;
        push(node);

        int mid = l + (r - l) / 2;

        //right side
        int res = queryRange(2 * node + 2, mid + 1, r);
        if (res != -1)
            return res;
        return queryRange(2 * node + 1, l, mid);
    }

    int queryRange() {
        return queryRange(0, 0, n - 1);
    }

}

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int[] nextPos = new int[n];
        Arrays.fill(nextPos, n);
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) {
                nextPos[i] = map.get(nums[i]);
            }
            map.put(nums[i], i);
        }

        int bal = 0;
        int[] pre = new int[n];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 0)
                pre[i] = pre[i - 1];

            if (!seen.contains(nums[i])) {
                if ((nums[i] & 1) == 1)
                    pre[i]++;
                else
                    pre[i]--;
                seen.add(nums[i]);
            }
        }

        Segment seg = new Segment(n, pre);
        int maxLen = seg.queryRange() + 1;

        for (int i = 1; i < n; i++) {
            int r = nextPos[i - 1] - 1;

            int val = (nums[i-1] & 1) == 1 ? -1 : 1;
            seg.addRange(0, r, 0, 0, n - 1, val);
            int pos = seg.queryRange();
            if (pos != -1) {
                maxLen = Math.max(maxLen, pos - i + 1);
            }
        }

        return maxLen;

    }
}