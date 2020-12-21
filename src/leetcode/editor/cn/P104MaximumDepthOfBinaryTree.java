//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 761 👎 0


package leetcode.editor.cn;

//Java：二叉树的最大深度
public class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
        TreeNode node3 = new P104MaximumDepthOfBinaryTree().new TreeNode(3);
        TreeNode node9 = new P104MaximumDepthOfBinaryTree().new TreeNode(9);
        TreeNode node20 = new P104MaximumDepthOfBinaryTree().new TreeNode(20);
        TreeNode node15 = new P104MaximumDepthOfBinaryTree().new TreeNode(15);
        TreeNode node17 = new P104MaximumDepthOfBinaryTree().new TreeNode(17);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node17;
        System.out.println(solution.maxDepth(node3));
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

        public int maxDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            int max = Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
            return max;
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
1. 5-15分钟读题思考题目

遍历每个节点的深度，寻找最大值
解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:38.4 MB,击败了72.53% 的Java用户

2. 没有思路则直接看解法，比较解法优劣
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

我的题解：
class Solution {

    private Integer maxValue = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return maxValue;
    }

    private void maxDepth(TreeNode root, Integer lastLevel) {
        if (root == null) {
            return;
        }
        maxValue =  Math.max(lastLevel +1,maxValue);
        maxDepth(root.left,lastLevel +1);
        maxDepth(root.right,lastLevel + 1);
    }
}

*/
}