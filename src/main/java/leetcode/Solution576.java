package leetcode;

public class Solution576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if ( maxMove == 0 ) {
            return 0;
        }

        long pathCount = 0L;
        for (int i = 1; i < maxMove+1; i++) {
            Long[][][] dp = new Long[m][n][51];
            pathCount += getNumberOfPathToMoveOutSide(dp, startRow, startColumn, i);
        }

        return (int) (pathCount % 1000000007);
    }

    private long getNumberOfPathToMoveOutSide(Long[][][] dp, int row, int col, int remainMove) {
        if ( remainMove == 0 ) {
            if ( row < 0 || row >= dp.length ) {
                return 1;
            } else if ( col < 0 || col >= dp[0].length ) {
                return 1;
            }

            return 0;
        } else {
            if ( row < 0 || row >= dp.length ) {
                return 0;
            } else if ( col < 0 || col >= dp[0].length ) {
                return 0;
            }

            if ( dp[row][col][remainMove] == null ) {
                long count = 0;
                count += getNumberOfPathToMoveOutSide(dp, row + 1, col, remainMove - 1) % 1000000007;
                count += getNumberOfPathToMoveOutSide(dp, row, col + 1, remainMove - 1) % 1000000007;
                count += getNumberOfPathToMoveOutSide(dp, row - 1, col, remainMove - 1) % 1000000007;
                count += getNumberOfPathToMoveOutSide(dp, row, col - 1, remainMove - 1) % 1000000007;
                dp[row][col][remainMove] = count;
            }
            return dp[row][col][remainMove] % 1000000007;
        }
    }

    public static void main(String[] args) {
        Solution576 solution = new Solution576();
        int paths = solution.findPaths(36, 5, 50, 15, 3);
        System.out.println(paths);
    }
}
