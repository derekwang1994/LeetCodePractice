// Given a 2D board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once.
//
// For example,
// Given board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.


public class Solution {
    public boolean exist(char[][] board, String word) {

        char[] w = word.toCharArray();

            for(int y=0; y<board.length; y++){
                for(int x=0; x<board[y].length;x++){
                    if( exist(board, x, y, w, 0) ) return true;
                }
            }

        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] w, int count){

        if( count==w.length ) return true;
        if( x<0 || y<0 || y>board.length-1 || x>board[y].length-1 ) return false;
        if( board[y][x]!=w[count] ) return false;

        board[y][x] ^= 256; // 將走過的給去掉 (board[y][x] = '*';) //
        boolean result = (exist(board, x+1, y, w, count+1))||(exist(board, x-1, y, w, count+1))
           				 ||(exist(board, x, y+1, w, count+1))||(exist(board, x, y-1, w, count+1)) ;
        board[y][x] ^= 256; // 將其復原 (board[y][x] = w[count];) //

        return result;
    }
}
