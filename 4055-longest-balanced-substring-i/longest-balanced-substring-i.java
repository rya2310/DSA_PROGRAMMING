class Solution {

    public int longestBalanced(String s) {

        int n = s.length();
        int max = 0;

        for(int left = 0; left < n; left++) {

            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for(int right = left; right < n; right++) {

                int idx = s.charAt(right) - 'a';

                if(freq[idx] == 0) distinct++;

                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                int length = right - left + 1;

                if(length == maxFreq * distinct) {
                    max = Math.max(max, length);
                }
            }
        }

        return max;
    }
}
