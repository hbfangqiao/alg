//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 729 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
        TreeNode node3 = new P102BinaryTreeLevelOrderTraversal().new TreeNode(3);
        TreeNode node9 = new P102BinaryTreeLevelOrderTraversal().new TreeNode(9);
        TreeNode node20 = new P102BinaryTreeLevelOrderTraversal().new TreeNode(20);
        TreeNode node15 = new P102BinaryTreeLevelOrderTraversal().new TreeNode(15);
        TreeNode node7 = new P102BinaryTreeLevelOrderTraversal().new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node7.right = node7;

        List<List<Integer>> lists = solution.levelOrder(node3);
        lists.forEach(e -> {
            System.out.println(e);
        });
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> results = new ArrayList<>();
            dfs(root,0,results);
            return results;
        }

        private void dfs(TreeNode node, int level, List<List<Integer>> results) {
            if (node == null) {
                return;
            }
            if (results.size() < level + 1) {
                results.add(new ArrayList<>());
            }
            List<Integer> list = results.get(level);
            list.add(node.val);
            dfs(node.left, level + 1, results);
            dfs(node.right, level + 1, results);
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
直接看BFS的标准写法
2. 比较解法优劣
BFS
DFS

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

BSF 标准写法:
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    if (root == null){
        return results;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()){
        int n = nodes.size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            TreeNode node = nodes.poll();
            result.add(node.val);
            if (node.left!=null){
                nodes.add(node.left);
            }
            if (node.right!=null){
                nodes.add(node.right);
            }
        }
        results.add(result);
    }
    return results;
}

DFS 我的解法：解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:38.6 MB,击败了74.46% 的Java用户
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    dfs(root,0,results);
    return results;
}

private void dfs(TreeNode node, int level, List<List<Integer>> results) {
    if (node == null) {
        return;
    }
    if (results.size() < level + 1) {
        results.add(new ArrayList<>());
    }
    List<Integer> list = results.get(level);
    list.add(node.val);
    dfs(node.left, level + 1, results);
    dfs(node.right, level + 1, results);
}
*/
}