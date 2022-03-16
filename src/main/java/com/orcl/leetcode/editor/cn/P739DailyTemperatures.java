//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度
//。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1055 👎 0

package com.orcl.leetcode.editor.cn;

import java.util.Stack;

/**
 * @description: P739 每日温度
 * @date: 2022-03-16 15:29:30
 * @author: orcl
 */
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int preIndex = stack.pop();
                    result[preIndex] = i - preIndex;
                }
                stack.push(i);
            }

            return result;
        }

//        public int[] dailyTemperatures1(int[] temperatures) {
//            int[] result = new int[temperatures.length];
//            for (int i = 0; i < temperatures.length; i++) {
//                for (int j = i; j < temperatures.length; j++) {
//                    if (temperatures[i] < temperatures[j]) {
//                        result[i] = j - i;
//                        break;
//                    }
//                }
//            }
//            return result;
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}