//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 864 👎 0


package leetcode.editor.cn;

//Java：验证二叉搜索树
public class P98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
        // TO TEST
        TreeNode treeNode1 = new P98ValidateBinarySearchTree().new TreeNode(1);
        TreeNode treeNode11 = new P98ValidateBinarySearchTree().new TreeNode(1);
        TreeNode treeNode2 = new P98ValidateBinarySearchTree().new TreeNode(2);
        TreeNode treeNode3 = new P98ValidateBinarySearchTree().new TreeNode(3);
        TreeNode treeNode4 = new P98ValidateBinarySearchTree().new TreeNode(4);
        TreeNode treeNode5 = new P98ValidateBinarySearchTree().new TreeNode(5);
        TreeNode treeNode6 = new P98ValidateBinarySearchTree().new TreeNode(6);
        TreeNode treeNode7 = new P98ValidateBinarySearchTree().new TreeNode(7);

        treeNode1.left = treeNode11;
        System.out.println(solution.isValidBST(treeNode1));

        System.out.println(solution.isValidBST(new P98ValidateBinarySearchTree().new TreeNode(2147483647)));

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode3;
        treeNode6.right = treeNode7;
        System.out.println(solution.isValidBST(treeNode5));
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
        public boolean isValidBST(TreeNode root) {
            return isValidBST(null, null, root);
        }

        private boolean isValidBST(Integer low, Integer upper, TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean flag = true;
            if ((low != null && root.val <= low) || (upper != null && root.val >= upper)) {
                flag = false;
            }
            return flag && isValidBST(low, root.val, root.left) && isValidBST(root.val, upper, root.right);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
/*
第一遍：
1. 5-15分钟读题思考题目 √
我的思路：重复问题是，每个节点的左子树 和 右子树都必须是 SBT 并且 左数所有节点 < root < 右树所有节点
解答失败: 测试用例:[5,4,6,null,null,3,7] 测试结果:true 期望结果:false stdout
犯的错误：BST 是左数所有节点均小于 根节点  而不是 只有左节点

阻塞原因： 我没有想出来如何写 左子树的所有节点

2. 没有思路则直接看解法，比较解法优劣
读了递归思路后写代码进行解答。主要出现的问题如下：
a.粗心，把root.right.val 往下传递，正确的应该是 root.val往下传递。
b.极值，初始值传了 Integer.MAX_VALUE 和 Integer.MIN_VALUE。导致出现这两个数的时候判断错误
c.概念混淆，针对于 root.val = 1   root.left.val = 1 的情况 认为这是正确的 BST
最终：
解答成功:
执行耗时:0 ms,击败了100.00% 的Java用户
内存消耗:37.8 MB,击败了96.31% 的Java用户

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