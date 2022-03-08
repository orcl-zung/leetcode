//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1264 👎 0

package com.orcl.leetcode.editor.cn;

import com.orcl.leetcode.editor.cn.support.ListNode;

/**
 * @description: 两两交换链表中的节点
 * @date: 2022-03-07 17:58:45
 * @author: orcl
 */
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {

            // 终止条件：链表只剩一个节点或者没有节点了，没有交换了。返回的就是已经处理好的链表
            if (head == null || head.next == null) {
                return head;
            }

            // 一共三个节点：head，next，swapPairs(next.next)
            // 下面的任务便是交换这3个节点中的前两个节点
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;

            // 根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
            return next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}