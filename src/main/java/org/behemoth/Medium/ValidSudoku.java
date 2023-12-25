package org.behemoth.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};

        char[][] board3 = {
              //  0   1   2   3   4   5   6   7   8
                {'.','.','.','.','5','.','.','1','.'}, // 0
                {'.','4','.','3','.','.','.','.','.'}, // 1
                {'.','.','.','.','.','3','.','.','1'}, // 2
                {'8','.','.','.','.','.','.','2','.'}, // 3
                {'.','.','2','.','7','.','.','.','.'}, // 4
                {'.','1','5','.','.','.','.','.','.'}, // 5
                {'.','.','.','.','.','2','.','.','.'}, // 6
                {'.','2','.','9','.','.','.','.','.'}, // 7
                {'.','.','4','.','.','.','.','.','.'}}; //8

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));
        System.out.println(isValidSudoku(board3));
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char c;
        Map<Character, List<Coord>> numbers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '.') {
                    c = board[i][j];
                    if (!numbers.containsKey(c)) {
                        numbers.put(c, new ArrayList<>());
                        numbers.get(c).add(new Coord(i, j));
                    }
                    else {
                        for (var e : numbers.get(c)) {
                            if (e.i == i || e.j == j || 10*(e.i/3)+e.j/3 == 10*(i/3)+j/3) return false;
                        }
                        numbers.get(c).add(new Coord(i, j));
                    }
                }
            }
        }
        return true;
    }

    private record Coord(int i, int j) {};
}
