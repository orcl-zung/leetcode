package com.orcl.leetcode.editor.cn.support;

import com.orcl.leetcode.editor.cn.P104MaximumDepthOfBinaryTree;

/**
 * @description:
 * @author: orcl
 * @since: 2022/3/8-16:34
 * @history: 2022/3/8 created by orcl
 */
public class TreeNode {

    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
