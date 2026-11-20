class Solution {
    private int solve(int i,int j,int n,int m,int[][] dp){
        if(i==n-1&&j==m-1)return 1;
        if(i>n||j>m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int right=solve(i+1,j,n,m,dp);
        int down=solve(i,j+1,n,m,dp);
        return dp[i][j]=right+down;
    }
    public int uniquePaths(int n, int m) {
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,n,m,dp);
    }
}