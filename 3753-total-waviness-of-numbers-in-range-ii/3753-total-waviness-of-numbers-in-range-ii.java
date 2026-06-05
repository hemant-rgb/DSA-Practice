class Solution {

    class Node {
        long count;
        long sum;

        Node(long count, long sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    String digits;
    Node[][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = String.valueOf(x);

        int n = digits.length();

        dp = new Node[n][11][11][2][2];

        return dfs(0, 10, 10, 0, 1).sum;
    }

    private Node dfs(
            int pos,
            int prev1,
            int prev2,
            int started,
            int tight) {

        if (pos == digits.length()) {
            return new Node(1, 0);
        }

        if (dp[pos][prev1][prev2][started][tight] != null) {
            return dp[pos][prev1][prev2][started][tight];
        }

        long totalCount = 0;
        long totalSum = 0;

        int limit =
                (tight == 1)
                        ? digits.charAt(pos) - '0'
                        : 9;

        for (int d = 0; d <= limit; d++) {

            int nextTight =
                    (tight == 1 && d == limit)
                            ? 1
                            : 0;

            if (started == 0 && d == 0) {

                Node child =
                        dfs(
                                pos + 1,
                                10,
                                10,
                                0,
                                nextTight);

                totalCount += child.count;
                totalSum += child.sum;
            } else {

                Node child =
                        dfs(
                                pos + 1,
                                d,
                                prev1,
                                1,
                                nextTight);

                long extra = 0;

                if (prev1 != 10 && prev2 != 10) {

                    boolean peak =
                            prev1 > prev2 &&
                            prev1 > d;

                    boolean valley =
                            prev1 < prev2 &&
                            prev1 < d;

                    if (peak || valley) {
                        extra = 1;
                    }
                }

                totalCount += child.count;

                totalSum +=
                        child.sum +
                        extra * child.count;
            }
        }

        return dp[pos][prev1][prev2][started][tight]
                = new Node(totalCount, totalSum);
    }
}