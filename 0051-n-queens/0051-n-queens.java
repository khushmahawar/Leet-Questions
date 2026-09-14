class Solution {
    private void helper(int n,char[][] grid,int ind,int k,List<List<String>> ans){
        if(k==n){
            List<String> list=new ArrayList<>();
            for(int p=0;p<n;p++){
            String str="";
                for(int i=0;i<n;i++){
                str+=grid[p][i];        
                }
                list.add(str);
            }
            ans.add(list);
            return;
        }
        for(int i=ind;i<n;i++){
            if(isSafe(i,grid,n,k)){
                grid[k][i]='Q';
                helper(n,grid,0,k+1,ans);
                grid[k][i]='.';
            }
        }
    }
    private boolean isSafe(int ind,char[][] grid,int n,int k){
        //row
        for(int i=0;i<n;i++){
            if(grid[i][ind]=='Q')return false;
        }
        for(int i=0;i<n;i++){
            if(grid[k][i]=='Q')return false;
        }
        for(int r=k-1, c=ind-1; r>=0 && c>=0; r--, c--) {
    if(grid[r][c] == 'Q') return false;
}
for(int r=k-1, c=ind+1; r>=0 && c<n; r--, c++) {
    if(grid[r][c] == 'Q') return false;
}

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] grid=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        helper(n,grid,0,0,ans);
        return ans;
    }
}