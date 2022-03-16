//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1467 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: P239 滑动窗口最大值
 * @date: 2022-03-16 16:54:39
 * @author: orcl
 */
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            MonotonicQueue windows = new MonotonicQueue();
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    windows.push(nums[i]);
                } else {
                    windows.push(nums[i]);
                    result.add(windows.max());
                    windows.pop(nums[i - k + 1]);
                }
            }
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        class MonotonicQueue {

            private LinkedList<Integer> mq = new LinkedList<>();


            /**
             * 在队尾添加元素n
             *
             * @param n
             */
            void push(int n) {
                while (!mq.isEmpty() && mq.getLast() < n) {
                    mq.pollLast();
                }
                mq.addLast(n);
            }

            /**
             * 返回当前队列中的最大值
             *
             * @return 返回最大值
             */
            int max() {
                return mq.getFirst();
            }

            /**
             * 队头元素如果是n，删除它
             *
             * @param n
             */
            void pop(int n) {
                if (n == mq.getFirst()) {
                    mq.pollFirst();
                }
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}