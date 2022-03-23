//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1233 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: P51 N 皇后
 * @date: 2022-03-23 14:59:28
 * @author: orcl
 */
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], '.');
            }

            backtrack(n, 0, board);

            return res;
        }

        private void backtrack(int n, int row, char[][] board) {
            if (row == n) {
                List<String> list = new ArrayList<>();
                for (char[] c : board) {
                    list.add(new String(c));
                }
                res.add(list);
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isValid(col, row, n, board)) {
                    board[row][col] = 'Q';
                    backtrack(n, row + 1, board);
                    board[row][col] = '.';
                }
            }
        }

        private boolean isValid(int col, int row, int n, char[][] board) {
            for (int i = 0; i < n; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }

            int i = col - 1;
            int j = row - 1;
            while (i >= 0 && j >= 0) {
                if (board[j][i] == 'Q') {
                    return false;
                }

                i--;
                j--;
            }

            i = col + 1;
            j = row - 1;

            while (i < n && j >= 0) {
                if (board[j][i] == 'Q') {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}