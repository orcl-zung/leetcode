//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1868 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: P46 全排列
 * @date: 2022-03-23 14:47:28
 * @author: orcl
 */
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            // 记录路径
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> track) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int num : nums) {
                // 排除不合法的选择
                if (track.contains(num)) {
                    continue;
                }

                // 做选择
                track.add(num);

                // 进入下一层决策树
                backtrack(nums, track);

                // 取消选择
                track.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}