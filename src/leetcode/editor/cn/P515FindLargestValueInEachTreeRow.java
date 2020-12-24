//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 116 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：在每个树行中找最大值
public class P515FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
        // TO TEST
        TreeNode node1 = new P515FindLargestValueInEachTreeRow().new TreeNode(1);
        TreeNode node3 = new P515FindLargestValueInEachTreeRow().new TreeNode(3);
        TreeNode node2 = new P515FindLargestValueInEachTreeRow().new TreeNode(2);
        TreeNode node5 = new P515FindLargestValueInEachTreeRow().new TreeNode(5);
        TreeNode node4 = new P515FindLargestValueInEachTreeRow().new TreeNode(4);
        TreeNode node9 = new P515FindLargestValueInEachTreeRow().new TreeNode(9);
        node1.left = node3;
        node1.right = node2;
        node3.left = node5;
        node2.left = node4;
        node2.right = node9;
        List<Integer> list = solution.largestValues(node1);
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Integer max = null;
            for (int i = 0; i <n ; i++) {
                TreeNode node = queue.poll();
                max = max == null ? node.val : Math.max(max,node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
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
BFS 对每一层遍历一次 O(2n) == O(n)
解答成功:
执行耗时:3 ms,击败了 34.04% 的Java用户
内存消耗:38.8 MB,击败了61.24% 的Java用户

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