//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1693 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P76 最小覆盖子串
 * @date: 2022-03-13 14:20:48
 * @author: orcl
 */
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {

            int[] window = new int[128];
            int[] need = new int[128];
            for (char c : t.toCharArray()) {
                need[c]++;
            }
            int distance = 0;
            for (int i : need) {
                if (i > 0) {
                    distance++;
                }
            }
            char[] chars = s.toCharArray();
            int left = 0, right = 0, cnt = 0;
            int start = 0, minLen = Integer.MAX_VALUE;
            while (right < chars.length) {
                char c1 = chars[right++];
                if (need[c1] > 0) {
                    window[c1]++;
                    if (window[c1] == need[c1]) {
                        cnt++;
                    }
                }
                while (cnt == distance) {
                    if (right - left < minLen) {
                        start = left;
                        minLen = right - left;
                    }
                    char c2 = chars[left++];
                    if (need[c2] > 0) {
                        if (window[c2] == need[c2]) {
                            cnt--;
                        }
                        window[c2]--;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}