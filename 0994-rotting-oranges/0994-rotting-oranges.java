class Solution {
    private int bfs(int[][] arr,Queue<int[]> q,int fresh,int max){
        int minutes=0;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0],c=curr[1],time=curr[2];
            minutes=time;
            int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int i=0;i<directions.length;i++){
               int nr=r+directions[i][0];
               int nc=c+directions[i][1];
               if(nr>=0&&nr<arr.length&&nc>=0&&nc<arr[0].length&&arr[nr][nc]==1){
                arr[nr][nc]=2;
                fresh--;
                q.offer(new int[]{nr,nc,time+1});
               }
            }

        }
        if(fresh!=0)return -1;
        return minutes; 
    }
    public int orangesRotting(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int fresh=0;
        int[][] rotten=new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1)fresh++;
                if(arr[i][j]==2)q.offer(new int[] {i,j,0});
            }
        }
        return bfs(arr,q,fresh,0);
        
    }
}