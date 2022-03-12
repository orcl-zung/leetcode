//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1518 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P34 在排序数组中查找元素的第一个和最后一个位置
 * @date: 2022-03-11 15:10:40
 * @author: orcl
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.rightBound(new int[]{5, 6, 8, 8, 9, 10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = leftBound(nums, target);
            int right = rightBound(nums, target);
            return new int[]{left, right};
        }

        public int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        }

        public int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}