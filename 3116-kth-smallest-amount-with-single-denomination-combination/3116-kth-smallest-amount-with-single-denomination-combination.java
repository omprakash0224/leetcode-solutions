class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1, right = (long)1e18; // safe upper bound
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countMultiples(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private long countMultiples(long x, int[] coins) {
        int n = coins.length;
        long total = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) { valid = false; break; }
                }
            }
            if (!valid) continue;
            long multiples = x / lcm;
            if (Integer.bitCount(mask) % 2 == 1) total += multiples;
            else total -= multiples;
        }
        return total;
    }
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}