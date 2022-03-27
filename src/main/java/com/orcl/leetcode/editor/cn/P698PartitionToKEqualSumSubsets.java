//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 517 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P698 划分为k个相等的子集
 * @date: 2022-03-25 14:03:52
 * @author: orcl
 */
public class P698PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        Solution solution = new P698PartitionToKEqualSumSubsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;
            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;

            boolean[] used = new boolean[nums.length];
            int target = sum / k;
            // k 号桶初始什么都没装，从 nums[0] 开始做选择
            return backtrack(k, 0, nums, 0, used, target);
        }

        boolean backtrack(int k, int bucket,
                          int[] nums, int start, boolean[] used, int target) {
            // base case
            if (k == 0) {
                // 所有桶都被装满了，而且 nums 一定全部用完了
                // 因为 target == sum / k
                return true;
            }
            if (bucket == target) {
                // 装满了当前桶，递归穷举下一个桶的选择
                // 让下一个桶从 nums[0] 开始选数字
                return backtrack(k - 1, 0 ,nums, 0, used, target);
            }

            // 从 start 开始向后探查有效的 nums[i] 装入当前桶
            for (int i = start; i < nums.length; i++) {
                // 剪枝
                if (used[i]) {
                    // nums[i] 已经被装入别的桶中
                    continue;
                }
                if (nums[i] + bucket > target) {
                    // 当前桶装不下 nums[i]
                    continue;
                }
                // 做选择，将 nums[i] 装入当前桶中
                used[i] = true;
                bucket += nums[i];
                // 递归穷举下一个数字是否装入当前桶
                if (backtrack(k, bucket, nums, i + 1, used, target)) {
                    return true;
                }
                // 撤销选择
                used[i] = false;
                bucket -= nums[i];
            }
            // 穷举了所有数字，都无法装满当前桶
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}