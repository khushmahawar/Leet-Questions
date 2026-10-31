class Solution {
    public long solve(int i,int[][] arr,long[] dp){
        if(i>arr.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        //System.out.print(arr[1][0]);
        long take=arr[i][0]+solve(i+arr[i][1]+1,arr,dp);
        long skip=solve(i+1,arr,dp);
        return dp[i]=Math.max(take,skip);
    }
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return solve(0,questions,dp);
    }
}