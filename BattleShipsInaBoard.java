class Solution {
    public int countBattleships(char[][] board) {
        int Bs = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    Bs++;
                    dfs(board, i, j);
                }
            }
        }
        return Bs;
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'X') {
            return;
        }
        board[i][j] = '*';

        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
    }
}