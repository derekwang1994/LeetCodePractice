// You are given an n x n 2D matrix representing an image.
// Rotate the image by 90 degrees (clockwise).

public class Solution {
    public void rotate(int[][] matrix) {
        // 123    136
        // 456 => 247
        // 789    358

        int n = matrix.length;
        int temp = 0;

        // swap [x,y] and [y,x]
        // notice: x starts from y
        for(int y=0; y<n; y++){
            for(int x=y; x<n; x++){
                temp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = temp;
            }
        }

        // swap [x,y] and [n-1-x,y]
        // notice: x<n/2
        for(int y=0; y<n; y++){
            for(int x=0; x<n/2; x++){
                temp = matrix[y][x];
                matrix[y][x] = matrix[y][n-1-x];
                matrix[y][n-1-x] = temp;
            }
        }

    }

}
