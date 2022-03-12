//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 702 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P704 二分查找
 * @date: 2022-03-11 11:40:22
 * @author: orcl
 */
public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        int result = solution.search(new int[]{5}, 6);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            // 首先定义搜索的左右区间
            int left = 0, right = nums.length - 1;

            // 循环搜索区间查找目标值
            while (left <= right) {
                // 取区间的中间值
                int mid = left + (right - left) / 2;

                // 如果中间位置的元素的值刚好与目标值相等，则返回中间值处的索引
                if (nums[mid] == target) {
                    return mid;
                }

                // 如果中间位置的元素的值比目标值小，则说明目标值在 [mid + 1, right] 区间
                else if (nums[mid] < target) {
                    // 调整左区间为 mid + 1，因为上面判断了 mid 处的值是否相等，则后续不用再比对
                    left = mid + 1;
                }

                // 如果中间位置的元素的值比目标值大，则说明目标值在 [left, mid - 1] 区间
                else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }

        public int search1(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}