//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 915 👎 0

package com.orcl.leetcode.editor.cn;

import com.orcl.leetcode.editor.cn.support.TreeNode;

/**
 * @description: P110 平衡二叉树
 * @date: 2022-03-08 16:33:15
 * @author: orcl
 */
public class P110BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            return isBST(root).isB;
        }

        /**
         * ReturnNode参考递归套路的第二步：思考返回值是什么
         * 一棵树是BST等价于它的左右俩子树都是BST且俩子树高度差不超过1
         * 因为返回值应该包含当前树是否是BST和当前树的高度两个参数
         */
        private class ReturnNode {
            boolean isB;
            int     depth;

            public ReturnNode(boolean isB, int depth) {
                this.isB = isB;
                this.depth = depth;
            }
        }

        /**
         * 递归套路第三部：描述单次执行过程是什么样
         * 这里的单次执行过程具体如下：
         * 是否终止 ? -> 没有终止的话，判断是否满足不平衡的三个条件 -> 返回值
         *
         * @param root 根节点
         * @return
         */
        public ReturnNode isBST(TreeNode root) {
            if (root == null) {
                return new ReturnNode(true, 0);
            }

            // 不平衡的情况有3中：左树不平衡、右树不平衡、左树和右树差的绝对值大于1
            ReturnNode left = isBST(root.left);
            ReturnNode right = isBST(root.right);

            if (!left.isB || !right.isB) {
                return new ReturnNode(false, 0);
            }

            if (Math.abs(left.depth - right.depth) > 1) {
                return new ReturnNode(false, 0);
            }

            // 不满足上面3种情况，说明平衡了，树的深度为左右俩子树最大深度 + 1
            return new ReturnNode(true, Math.max(left.depth, right.depth) + 1);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}