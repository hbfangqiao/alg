//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 800 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST
        TreeNode treeNode1 = new P94BinaryTreeInorderTraversal().new TreeNode(1);
        TreeNode treeNode2 = new P94BinaryTreeInorderTraversal().new TreeNode(2);
        TreeNode treeNode3 = new P94BinaryTreeInorderTraversal().new TreeNode(3);
        treeNode2.left = treeNode3;
        treeNode1.right = treeNode2;
        List<Integer> list = solution.inorderTraversal(treeNode1);
        System.out.println(list);

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private void inorder(TreeNode root,List<Integer> res){
        if (root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right, res);
    }
}


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


//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目。√
 因为是标准写法，直接看题解理解记忆。
2. 没有思路则直接看解法，比较解法优劣
3. 背诵和默写解法 √
第二遍
1. 马上自己写 -> LeeCode提交 √
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习	
*/
}