class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] col = new HashSet[9];
        Set<Character>[][] squares = new HashSet[3][3];
         for(int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                squares[i][j] = new HashSet<>();
            }
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(row[i].contains(board[i][j]) ||
                col[j].contains(board[i][j]) ||
                squares[i / 3][j / 3].contains(board[i][j])){
                    return false;
                }
                row[i].add(board[i][j]);
                col[j].add(board[i][j]);
                squares[i / 3][j / 3].add(board[i][j]);
            }
        }
        return true;
    }
}
