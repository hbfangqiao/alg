//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 422 👎 0


package leetcode.editor.cn;
//Java：二叉树的最小深度
public class P111MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
        // TO TEST
        TreeNode node3 = new P111MinimumDepthOfBinaryTree().new TreeNode(3);
        TreeNode node9 = new P111MinimumDepthOfBinaryTree().new TreeNode(9);
        TreeNode node20 = new P111MinimumDepthOfBinaryTree().new TreeNode(20);
        TreeNode node15 = new P111MinimumDepthOfBinaryTree().new TreeNode(15);
        TreeNode node17 = new P111MinimumDepthOfBinaryTree().new TreeNode(17);
        node3.left = node9;
        node9.left = node20;
        node20.left = node15;
        node15.left = node17;
        System.out.println(solution.minDepth(node3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：按P104的思路，返回最小值。解答失败 [2,null,3,null,4,null,5,null,6]  预期5，实际1

2. 没有思路则直接看解法

叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
当 root 节点左右孩子都为空时，返回 1
当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值

链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/

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