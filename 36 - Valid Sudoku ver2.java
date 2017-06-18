// more concise solution //

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<board.length; i++){
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();

            for(int j=0; j<board[i].length; j++){

                if(row.contains(board[i][j]) && board[i][j]!='.') return false;
                if(col.contains(board[j][i]) && board[j][i]!='.') return false;
                row.add(board[i][j]);
                col.add(board[j][i]);

                int rowIndex = 3*(i/3) + j/3;
                int colIndex = 3*(i%3) + j%3;

                if(cube.contains(board[rowIndex][colIndex]) && board[rowIndex][colIndex]!='.') return false;
                cube.add(board[rowIndex][colIndex]);
            }

        }

        return true;
    }
}
