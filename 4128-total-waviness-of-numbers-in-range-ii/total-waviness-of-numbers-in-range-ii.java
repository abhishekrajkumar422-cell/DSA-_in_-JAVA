class Solution {

    private String s;
    private long[][][][][] memoCnt;
    private long[][][][][] memoSum;
    private boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {

        if (x <= 0) return 0;

        s = String.valueOf(x);

        int n = s.length();

        memoCnt = new long[n][11][11][2][2];
        memoSum = new long[n][11][11][2][2];
        vis = new boolean[n][11][11][2][2];

        return dfs(0, 10, 10, 0, 1)[1];
    }

    private long[] dfs(int pos,
                       int prev1,
                       int prev2,
                       int started,
                       int tight) {

        if (pos == s.length()) {
            return new long[]{1, 0};
        }

        if (tight == 0 &&
            vis[pos][prev1][prev2][started][0]) {

            return new long[]{
                memoCnt[pos][prev1][prev2][started][0],
                memoSum[pos][prev1][prev2][started][0]
            };
        }

        int limit =
            tight == 1 ? s.charAt(pos) - '0' : 9;

        long count = 0;
        long sum = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight =
                (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                long[] next =
                    dfs(pos + 1, 10, 10, 0, ntight);

                count += next[0];
                sum += next[1];
            } else {

                int add = 0;

                if (prev2 != 10) {

                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                long[] next =
                    dfs(pos + 1,
                        d,
                        prev1,
                        1,
                        ntight);

                count += next[0];

                sum += next[1]
                        + next[0] * add;
            }
        }

        if (tight == 0) {

            vis[pos][prev1][prev2][started][0] =
                true;

            memoCnt[pos][prev1][prev2][started][0] =
                count;

            memoSum[pos][prev1][prev2][started][0] =
                sum;
        }

        return new long[]{count, sum};
    }
}