//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 803 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: P438 找到字符串中所有字母异位词
 * @date: 2022-03-13 15:02:26
 * @author: orcl
 */
public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] target = new int[26];
            for (int i = 0; i < p.length(); i++) {
                target[p.charAt(i) - 'a']++;
            }

            int left = 0, right = 0;
            int[] windows = new int[26];
            List<Integer> result = new ArrayList<>();

            while (right < s.length()) {
                windows[s.charAt(right) - 'a']++;

                if (right - left + 1 == p.length()) {
                    if (Arrays.equals(windows, target)) {
                        result.add(left);
                    }
                    windows[s.charAt(left) - 'a']--;
                    left++;
                }
                right++;
            }
            return result;
        }

        public List<Integer> findAnagrams1(String s, String p) {

            List<Character> characters = new ArrayList<>();
            char[] chars = p.toCharArray();
            char[] source = s.toCharArray();
            for (char aChar : chars) {
                characters.add(aChar);
            }

            for (int i = 0; i < source.length; i++) {
                if (characters.contains(source[i])) {

                }
            }


            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}