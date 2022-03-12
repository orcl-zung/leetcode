//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
// 
//
// 示例 2： 
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
// 
//
// 示例 3： 
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// Related Topics 数组 二分查找 👍 266 👎 0

package com.orcl.leetcode.editor.cn;

/**
 * @description: P875 爱吃香蕉的珂珂
 * @date: 2022-03-12 14:54:30
 * @author: orcl
 * <p>
 * 1、确定 x, f(x), target 分别是什么，并写出函数 f 的代码。
 * <p>
 * 2、找到 x 的取值范围作为二分搜索的搜索区间，初始化 left 和 right 变量。
 * <p>
 * 3、根据题目的要求，确定应该使用搜索左侧还是搜索右侧的二分搜索算法，写出解法代码。
 */
public class P875KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new P875KokoEatingBananas().new Solution();
        int result = solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = 1000000000 + 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (f(piles, mid) <= h) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }

        /**
         * 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
         * f(x) 随着 x 的增加单调递减
         *
         * @param piles n 堆香蕉
         * @param x     吃香蕉的速度
         * @return 吃完所有香蕉耗费时间
         */
        int f(int[] piles, int x) {
            int hours = 0;
            for (int pile : piles) {
                hours += pile / x;
                if (pile % x > 0) {
                    hours++;
                }
            }
            return hours;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}