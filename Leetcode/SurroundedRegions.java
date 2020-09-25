class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0)
            return ;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0 ; i < m ; i++) 
            for(int j = 0 ; j < n ; j++) 
                if(j == 0 || j == n - 1 || i == 0 || i == m - 1) 
                    dfs(board, i , j);
        
        for(int i = 0 ; i < m ; i++) 
            for(int j = 0 ; j < n ; j++) 
                if( board[i][j] == '#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
    }
    
    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if(board[i][j] == 'X' || board[i][j] == '#')
            return;
        
        board[i][j] = '#';  // MARKING VISITED
        int dir[][] = { {-1,0}, {1,0}, {0,-1}, {0,1} };
        for(int idx = 0 ; idx < dir.length ; idx++) {
            int r = i + dir[idx][0];
            int c = j + dir[idx][1];
            
            if(r >= 0 && r < m && c >= 0 && c < n)
                dfs(board, r, c);
        }
    }
}