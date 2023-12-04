package org.behemoth.Easy;

import java.util.Arrays;

public class MaxSquareSubmatrix {
    public static void main(String[] args) {
        int[][] in = new int[][] {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(square(in));
        System.out.println(Integer.valueOf('1'));
        System.out.println('9' + 1);
    }

    public static int square(int[][] M){
        int max = 0;

        int[][] temp = new int[M.length][M[0].length];

        for (int i = 0; i < M[0].length; i++) {
            temp[0][i] = M[0][i];
            if (temp[0][i] > max) max = temp[0][i];
        }

        for (int i = 0; i < M.length; i++) {
            temp[i][0] = M[i][0];
            if (temp[i][0] > max) max = temp[i][0];
        }

        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                if (M[i][j] != 0) {
                    temp[i][j] =
                            Math.min(
                            temp[i - 1][j - 1],
                            Math.min(temp[i - 1][j], temp[i][j-1])
                            ) + 1;
                    if (max < temp[i][j]) max = temp[i][j];
                }
            }
        }

        for (var r : temp) System.out.println(Arrays.toString(r));

        return max*max;
    }
}
