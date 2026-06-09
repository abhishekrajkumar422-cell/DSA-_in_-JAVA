class Solution {

    public int solve(int[] nums, int curr, int prev, int[][] dp) {

        if (curr == nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int take = 0;

        if (prev == -1 || nums[curr] > nums[prev]) {
            take = 1 + solve(nums, curr + 1, curr, dp);
        }

        int skip = solve(nums, curr + 1, prev, dp);

        return dp[curr][prev + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, -1, dp);
    }
}