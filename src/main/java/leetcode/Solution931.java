package leetcode;

public class Solution931 {

    private int min;
    private int[][] matrix;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.min = 10000;

        if ( matrix.length == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] firstRow = matrix[0];
            //recursive
            setSumOfFallingPathIfLessThanMinValue(1, i, firstRow[i]);
        }

        return this.min;
    }

    private void setSumOfFallingPathIfLessThanMinValue(int floor, int upperIndex, int sum) {
        if ( floor == matrix.length ) {
            if ( this.min > sum ) {
                this.min = sum;
            }
            return;
        }

        int[] row = matrix[floor];
        for (int i = upperIndex-1; i <= upperIndex+1; i++) {
            if ( i < 0 || i > matrix.length-1 ) {
                continue;
            }
            setSumOfFallingPathIfLessThanMinValue(floor + 1, i,sum + row[i]);
        }
    }
}
