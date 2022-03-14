//给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 不允许修改 链表。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶：你是否可以使用 O(1) 空间解决此题？ 
// Related Topics 哈希表 链表 双指针 👍 1447 👎 0

package com.orcl.leetcode.editor.cn;

import com.orcl.leetcode.editor.cn.support.ListNode;

/**
 * @description: P142 环形链表 II
 * @date: 2022-03-14 09:27:05
 * @author: orcl
 */
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head, second = head;

            // 首先判断是否有环
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                // 当慢指针和快指针相遇，说明有环
                if (slow == fast) {

                    // 有环的话，分别从相遇节点、头节点以相同的步长移动，再次相遇即为入环节点
                    // 这里假设 头节点到入环节点的距离为 a ，入环节点到相遇节点的距离为 b ，相遇节点到入环节点的距离为 c
                    // 头节点为 H ，入环节点为 A ， 相遇节点为 B
                    // 快、慢指针相遇各自走过的距离：
                    // 快：a + b + c + b
                    // 慢：a + b
                    // 因为快指针的步长是慢指针的2倍，所以快指针走过的距离一定也是慢指针的2倍
                    // 于是就有这样一个等式： 2(a + b) = a + b + c + b，也就有了 a = c
                    while (second != fast) {
                        fast = fast.next;
                        second = second.next;
                    }
                    return second;
                }
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}