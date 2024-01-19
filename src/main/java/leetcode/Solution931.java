package leetcode;

public class Solution931 {

    private int min;
    private int[][] matrix;
    private Integer[][] minMatrix;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        this.min = 10000;
        this.minMatrix = new Integer[matrix.length][matrix.length];

        if ( matrix.length == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            //recursive
            min = Math.min(min, getMinimumSumationOfFallingPathIfLessThanMinValue(0, i));
        }

        return this.min;
    }

    private int getMinimumSumationOfFallingPathIfLessThanMinValue(int floor, int index) {
        if ( floor == matrix.length-1 ) {
            return matrix[floor][index];
        }

        int value = matrix[floor][index];
        int minValueOfChild = 10000;
        for (int i = index-1; i <= index+1; i++) {
            if ( i < 0 || i > matrix.length-1 ) {
                continue;
            }
            if ( minMatrix[floor+1][i] == null ) {
                minMatrix[floor+1][i] = getMinimumSumationOfFallingPathIfLessThanMinValue(floor + 1, i);
            }
            minValueOfChild = Math.min(minValueOfChild, minMatrix[floor+1][i]);
        }
        return value + minValueOfChild;
    }
}
