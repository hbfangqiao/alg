//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 874 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：二叉树的最近公共祖先
public class P236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
        TreeNode treeNode3 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(3);
        TreeNode treeNode5 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(5);
        TreeNode treeNode1 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(1);
        TreeNode treeNode6 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(6);
        TreeNode treeNode2 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(2);
        TreeNode treeNode0 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(0);
        TreeNode treeNode8 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(8);
        TreeNode treeNode7 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(7);
        TreeNode treeNode4 = new P236LowestCommonAncestorOfABinaryTree().new TreeNode(4);
        //
        treeNode3.left = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode3.right = treeNode1;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;

        TreeNode treeNode = solution.lowestCommonAncestor(treeNode3, treeNode5, treeNode2);
        System.out.println(treeNode.val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null){
                return root;
            }
            Deque<TreeNode> roadP = new ArrayDeque<>();
            listRoad(root, p, roadP);
            Deque<TreeNode> roadQ = new ArrayDeque<>();
            listRoad(root,q,roadQ);
            TreeNode result = root;
            while (roadP.peekFirst() == roadQ.peekFirst()){
                result = roadP.pollFirst();
                roadQ.pollFirst();
            }
            return result;
        }

        private void listRoad(TreeNode root, TreeNode p, Deque<TreeNode> result) {
            if (root == null || p.equals(result.peek())) {
                return;
            }
            result.offerLast(root);
            listRoad(root.left, p, result);
            listRoad(root.right, p, result);
            if (!p.equals(result.peekLast())) {
                result.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：获取每个node 的路线List。获得两个node 最后一个相同的 node。即为公共祖先 时间复杂度 O(3n) = O(n)
解答成功: 执行耗时:12 ms,击败了15.38% 的Java用户 内存消耗:40.1 MB,击败了95.48% 的Java用户

2. 比较解法优劣
官方两种解法：
a. 如果Node  左子树 和 右子树 中 均包含了 p 或者 q  那么Node 是最近公共祖先。 如果 Node 是p,q 其中一个,那么
只需要 左子树或者右子树包含p或q其中一个，那么Node即为最近公共祖先 O(n)
b. 记录所有节点的父节点，从p,q分别往上进行遍历。这个和我们解法类似。 O(n)

3. 背诵和默写解法
第二遍
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习	
*/
}