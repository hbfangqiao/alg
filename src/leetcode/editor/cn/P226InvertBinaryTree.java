//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 714 👎 0


package leetcode.editor.cn;
//Java：翻转二叉树
public class P226InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode invertRight = invertTree(root.right);
        TreeNode invertLeft = invertTree(root.left);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
/*
第一遍：
1. 5-15分钟读题思考题目 √
我的思路：抽象出翻转二叉树的重复子问题就是 交换左子树 和 右子树
实现过程中：
a.left = invert(right)；right = invert(left) 的写法，导致左子树丢失
b.输入空树的时候，又 出现了 空指针。反复出现多次了，应该多加注意

解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:35.6 MB,击败了92.32% 的Java用户

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
*/
}