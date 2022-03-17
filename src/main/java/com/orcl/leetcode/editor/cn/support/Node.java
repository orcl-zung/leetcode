package com.orcl.leetcode.editor.cn.support;

/**
 * @description:
 * @author: orcl
 * @since: 2022/3/17-15:02
 * @history: 2022/3/17 created by orcl
 */
public class Node {

    public int  val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
