package leetcode;

public class Solution576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //dp
        Integer[][] dp = new Integer[m][n];

        int count = getNumberOfPathToMoveOutSide(dp, startRow, startColumn, maxMove);

        return count;
    }

    private int getNumberOfPathToMoveOutSide(Integer[][] dp, int row, int col, int remainMove) {
        if ( row < 0 || row >= dp.length ) {
            return 1;
        } else if ( col < 0 || col >= dp[0].length ) {
            return 1;
        }

        if ( remainMove == 0 ) {
            return 0;
        }

        int count = 0;
        if ( dp[row][col] == null ) {
            count += getNumberOfPathToMoveOutSide(dp, row+1, col, remainMove - 1);
            count += getNumberOfPathToMoveOutSide(dp, row, col+1, remainMove - 1);
            count += getNumberOfPathToMoveOutSide(dp, row-1, col, remainMove - 1);
            count += getNumberOfPathToMoveOutSide(dp, row, col-1, remainMove - 1);
            dp[row][col] = count;
        }
        return dp[row][col];
    }
}
