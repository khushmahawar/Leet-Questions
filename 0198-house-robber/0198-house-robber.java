class Solution {
    private int solve(int i,int[] arr,int[] dp){
        if(i>=arr.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=arr[i]+solve(i+2,arr,dp);
        int skip=solve(i+1,arr,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
}