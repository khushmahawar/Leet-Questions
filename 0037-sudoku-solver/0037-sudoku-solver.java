class Solution {
        private boolean agree(int row, int col, int num, char[][] board) {
            char c = (char)(num + '0');
        for(int i=0; i<9; i++) {
            if(board[row][i] == c) return false; 
            if(board[i][col] == c) return false; 
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[startRow+i][startCol+j] == c) return false;
            }
        }
        return true;
    }
      
    private boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
            if(board[i][j]=='.'){
                for(int p=1;p<=9;p++){
                    if(agree(i,j,p,board)){
                        board[i][j]=(char)(p+'0');
                        if(helper(board))return true;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}