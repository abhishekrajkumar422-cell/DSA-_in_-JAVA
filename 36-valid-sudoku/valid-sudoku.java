import java.util.*;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                // Empty cell ko ignore karo
                if (num == '.') {
                    continue;
                }

                // Row check
                String rowKey = "row" + row + num;

                // Column check
                String colKey = "col" + col + num;

                // 3 × 3 box check
                String boxKey = "box" + (row / 3) + (col / 3) + num;

                // Agar koi key already present hai
                if (set.contains(rowKey) ||
                    set.contains(colKey) ||
                    set.contains(boxKey)) {

                    return false;
                }

                // Teeno information Set me add karo
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }

        return true;
    }
}