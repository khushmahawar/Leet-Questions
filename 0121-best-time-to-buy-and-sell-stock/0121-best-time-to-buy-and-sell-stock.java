class Solution {
    int[][][] dp;
    private int solve(int i, int buy, int cap, int[] prices) {
        if (i == prices.length || cap == 0)
            return 0;

        if (dp[i][buy][cap] != -1)
            return dp[i][buy][cap];

        int profit;

        if (buy == 1) {
            profit = Math.max(
                    -prices[i] + solve(i + 1, 0, cap, prices), // Buy
                    solve(i + 1, 1, cap, prices)              // Skip
            );
        } else {
            profit = Math.max(
                    prices[i] + solve(i + 1, 1, cap - 1, prices), // Sell
                    solve(i + 1, 0, cap, prices)                  // Skip
            );
        }

        return dp[i][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 1, 1, prices);
    }
}