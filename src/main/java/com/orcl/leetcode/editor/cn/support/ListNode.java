package com.orcl.leetcode.editor.cn.support;

/**
 * @description:
 * @author: orcl
 * @since: 2022/3/7-18:00
 * @history: 2022/3/7 created by orcl
 */
public class ListNode {

    public int      val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
