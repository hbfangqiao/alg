//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 801 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode node = solution.buildTree(preorder, inorder);
        System.out.println("");
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

    private Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i <inorder.length ; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length-1,0);
    }

    private TreeNode buildTree(int[] preorder,int preorderLeft,int preorderRight,int inorderLeft){
        if (preorderLeft > preorderRight){
            return null;
        }
        //获取根节点在中序遍历中的位置
        int headVal = preorder[preorderLeft];
        int inorderRootIndex = indexMap.get(headVal);
        //构建根节点
        TreeNode rootNode = new TreeNode(headVal);
        //获取左子树元素的数量
        int leftSubtreeSize  = inorderRootIndex - inorderLeft;
        rootNode.left = buildTree(preorder,preorderLeft+1,preorderLeft+leftSubtreeSize,inorderLeft);
        rootNode.right = buildTree(preorder,preorderLeft+leftSubtreeSize+1,preorderRight,inorderRootIndex+1);
        return rootNode;
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
1. 5-15分钟读题思考题目 √ 没有思路
2. 没有思路则直接看解法，比较解法优劣
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/

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