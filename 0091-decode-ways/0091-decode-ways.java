class Solution {
    public int solve(int i, String str,int[] dp) {
        if (i == str.length()) return 1;
        if (str.charAt(i) == '0') return 0;
        if(dp[i]!=-1)return dp[i];
        int one = solve(i + 1, str,dp);
        if (i + 1 < str.length()) {
            int num = Integer.parseInt(str.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                one += solve(i + 2, str,dp);
            }
        }
        return dp[i]=one;
    }

    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(0, s,dp);
    }
}
