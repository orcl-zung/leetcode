//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。 
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... 
//endIndex]（包括 startIndex 和 endIndex）增加 inc。 
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
// Related Topics 数组 前缀和 👍 114 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @description: P370 区间加法
 * @date: 2022-03-09 10:23:13
 * @author: orcl
 */
public class P370RangeAddition {
    public static void main(String[] args) {
        Solution solution = new P370RangeAddition().new Solution();
        int[] array = solution.getModifiedArray(5, new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        });
        System.out.println(Arrays.toString(array));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getModifiedArray(int length, int[][] updates) {
            Difference difference = new Difference(new int[length]);
            for (int[] update : updates) {
                difference.increment(update[0], update[1], update[2]);
            }
            return difference.getDiffNums();
        }

        private class Difference {
            /**
             * 差分数组
             */
            public int[] diffNums;

            public Difference(int[] nums) {
                assert nums.length > 0;

                diffNums = new int[nums.length];
                diffNums[0] = nums[0];

                // 构造差分数组
                for (int i = 1; i < nums.length; i++) {
                    diffNums[i] = nums[i] - nums[i - 1];
                }
            }

            /**
             * 修改差分数组
             *
             * @param left  左边界
             * @param right 右边界
             * @param val   修改值
             */
            public void increment(int left, int right, int val) {
                diffNums[left] += val;

                // 如果右边界 + 1 大于等于差分数组长度，说明要改变原数组left之后所有的元素
                if (right + 1 < diffNums.length) {
                    diffNums[right + 1] -= val;
                }
            }

            /**
             * 根据修改后的差分数组返回变化后的新数组
             *
             * @return
             */
            public int[] getDiffNums() {
                int[] nums = new int[diffNums.length];
                nums[0] = diffNums[0];
                for (int i = 1; i < diffNums.length; i++) {
                    nums[i] = diffNums[i] + nums[i - 1];
                }

                return nums;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}