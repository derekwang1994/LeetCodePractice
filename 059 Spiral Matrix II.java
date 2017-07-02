// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// For example,
//   Given n = 3,
//   You should return the following matrix:
//   [
//    [ 1, 2, 3 ],
//    [ 8, 9, 4 ],
//    [ 7, 6, 5 ]
//   ]

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = n-1;
        int i=0;

        while( i<Math.pow(n, 2) ){
            for(int j=startRow; j<=endRow; j++){
                result[startCol][j] = ++i;
            }
            startCol++;
            for(int j=startCol;j<=endCol;j++){
                result[j][endRow] = ++i;
            }
            endRow--;
            for(int j=endRow; j>=startRow; j--){
                result[endCol][j] = ++i;
            }
            endCol--;
            for(int j=endCol; j>=startCol; j--){
                result[j][startRow] = ++i;
            }
            startRow++;
        }

        return result;
    }
}
