class Solution {
    private boolean dfs(char[][] board,String word,int i,int j,int k,boolean[][] vis){
        
        if(k==word.length()-1)return true;
        //if(i>board.length||i<0||j>board[0].length||j<0)return false;
        
        if(i>0&&!vis[i-1][j]&&(board[i-1][j]==word.charAt(k+1))){//up
        vis[i-1][j]=true;
        if(dfs(board,word,i-1,j,k+1,vis))return true;;
        vis[i-1][j]=false;
        }

        if(i<board.length-1&&!vis[i+1][j]&&(board[i+1][j]==word.charAt(k+1))){//down
        vis[i+1][j]=true;
        if(dfs(board,word,i+1,j,k+1,vis))return true;
        vis[i+1][j]=false;
        }
        
        if(j>0&&!vis[i][j-1]&&(board[i][j-1]==word.charAt(k+1))){//left
        vis[i][j-1]=true;
        if(dfs(board,word,i,j-1,k+1,vis))return true;
        vis[i][j-1]=false;
        }
        
        if(j<board[0].length-1&&!vis[i][j+1]&&(board[i][j+1]==word.charAt(k+1))){//right
        vis[i][j+1]=true;
        if(dfs(board,word,i,j+1,k+1,vis))return true;
        vis[i][j+1]=false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    vis[i][j]=true;
                    if(dfs(board,word,i,j,0,vis))return true;
                    vis[i][j]=false;
                }
            }
        }
        return false;
    }
}