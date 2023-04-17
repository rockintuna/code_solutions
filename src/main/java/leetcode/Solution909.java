package leetcode;

public class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        int[] arr = new int[(int) Math.pow(n, 2)];

        for (int i = 0; i < board.length; i++) {
            if ( i % 2 == 0 ) {
                for (int j = 0; j < board.length; j++) {
                    int next = board[i][j];

                }
            }
            int[] ints = board[i];

        }

        return arr.length;
    }

    public static void main(String[] args) {
        Solution909 solution909 = new Solution909();

        int i = solution909.snakesAndLadders(new int[][]{new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, -1, -1, -1, -1, -1},
                new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, 35, -1, -1, 13, -1}, new int[]{-1, -1, -1, -1, -1, -1}, new int[]{-1, 15, -1, -1, -1, -1}});

        System.out.println(i);
    }
}
