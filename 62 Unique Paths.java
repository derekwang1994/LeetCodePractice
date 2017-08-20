// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// |s| | | | | | |
// | | | | | | | |
// | | | | | | |f|
// How many possible unique paths are there?
// Above is a 3 x 7 grid. How many possible unique paths are there?
// Note: m and n will be at most 100.

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] map = new int[m][n];

        // every square on the left side only has one unique path
        for(int i=0; i<m; i++){
            map[i][0] = 1;
        }
        // every square on the top side only has one unique path
        for(int j=0; j<n; j++){
            map[0][j] = 1;
        }
        // the number of the unique path of each square is the sum of its left and top
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        return map[m-1][n-1];
    }
}
