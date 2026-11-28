class Solution {
    private boolean helper(char[][] board, String word, int index, int i, int j){
      if(index == word.length()){
        return true;
      }

      if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j]) {
          return false;
      }

      char temp = board[i][j];
      board[i][j] = ' ';
      boolean ans = helper(board, word, index + 1, i - 1, j) ||
                    helper(board, word, index + 1, i + 1, j) || 
                    helper(board, word, index + 1, i, j - 1) || 
                    helper(board, word, index + 1, i, j + 1);
      board[i][j] = temp;

      return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
            if(word.charAt(0) == board[i][j]){
              if(helper(board, word, 0, i, j)) return true;
            }
          }
        }
      return false;
    }
}
