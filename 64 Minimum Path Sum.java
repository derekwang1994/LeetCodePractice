// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

Solution 1: Space O(m*n)
class Solution {
    public int minPathSum(int[][] grid) {
        int sum = 0;
        int m=grid.length, n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1; j<n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}

Solution 2: Space O(n)
class Solution {
    public int minPathSum(int[][] grid) {

        int m=grid.length, n=grid[0].length;
        // dp[i] == min path sum to previous row's column i.
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for(int j=1; j<n; j++){
            dp[j] = dp[j-1] + grid[0][j];// set the value for the top row of the table
        }

        for(int i=1; i<m; i++){
            dp[0] += grid[i][0]; // set the value for the far left column of the table
            for(int j=1; j<n; j++){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]); // set the value for the current index
            }
        }

        return dp[n-1];
    }
}
