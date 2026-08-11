class Solution {
    public int longestPalindromeSubseq(String s) {

        int m = s.length();

        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, m - 1, s, dp);
    }

    public int solve(int i, int j, String s, int[][] dp) {

        if (i > j) return 0;

        if (i == j) return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {

            dp[i][j] = 2 + solve(i + 1, j - 1, s, dp);

        } else {

            dp[i][j] = Math.max(
                solve(i + 1, j, s, dp),
                solve(i, j - 1, s, dp)
            );
        }

        return dp[i][j];
    }
}