class Solution {
    public int solve(int i,int[] arr,int[] dp){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        
        int take=arr[i]+solve(i-2,arr,dp);
        int skip=solve(i-1,arr,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[] arr=new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }
        int[] dp=new int[max+2];
        Arrays.fill(dp,-1);
        return solve(arr.length-1,arr,dp);
    }
}