// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

public class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> row = new HashSet<Character>();
        Set<Character> col = new HashSet<Character>();
        Set<Character> cube1 = new HashSet<Character>();
        Set<Character> cube2 = new HashSet<Character>();
        Set<Character> cube3 = new HashSet<Character>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){

                if(row.contains(board[i][j]) && board[i][j]!='.') return false;
                if(col.contains(board[j][i]) && board[j][i]!='.') return false;
                row.add(board[i][j]);
                col.add(board[j][i]);

                if(j>=0 && j<=2){
                    if(cube1.contains(board[i][j]) && board[i][j]!='.') return false;
                    cube1.add(board[i][j]);
                }
                if(j>=3 && j<=5){
                    if(cube2.contains(board[i][j]) && board[i][j]!='.') return false;
                    cube2.add(board[i][j]);
                }
                if(j>=6 && j<=8){
                    if(cube3.contains(board[i][j]) && board[i][j]!='.') return false;
                    cube3.add(board[i][j]);
                }

            }
            row.clear();
            col.clear();
            if(i==2||i==5||i==8){
                cube1.clear();
                cube2.clear();
                cube3.clear();
            }
        }

        return true;
    }
}
