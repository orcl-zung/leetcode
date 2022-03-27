//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2481 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: P22 括号生成
 * @date: 2022-03-25 14:03:38
 * @author: orcl
 */
public class P22GenerateParentheses {
    public static void main(String[] args) {

        Solution solution = new P22GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, n, "");
            return result;
        }

        private void dfs(int left, int right, String cur) {
            if (left == 0 && right == 0) {
                result.add(cur);
                return;
            }

            if (left > 0) {
                dfs(left - 1, right, cur + "(");
            }

            if (right > left) {
                dfs(left, right - 1, cur + ")");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}