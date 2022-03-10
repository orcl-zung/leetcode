//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4832 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P5 最长回文子串
 * @date: 2022-03-10 11:48:50
 * @author: orcl
 */
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                // 以 s[i] 为中心的最长回文子串
                String s1 = palindrome(s, i, i);

                // 以 s[i] 和 s[i + 1] 为中心的最长回文子串
                String s2 = palindrome(s, i, i + 1);

                // result = longest(res, s1, s2)
                result = result.length() > s1.length() ? result : s1;
                result = result.length() > s2.length() ? result : s2;
            }

            return result;
        }

        public String palindrome(String s, int left, int right) {
            // 防止索引越界
            while (left >= 0
                    && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // 返回以 s[left] 、 s[right] 为中心的最长回文串
            return s.substring(left + 1, right);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}