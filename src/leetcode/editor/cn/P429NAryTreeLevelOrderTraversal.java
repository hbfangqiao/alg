//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
// Related Topics 树 广度优先搜索 
// 👍 121 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：N 叉树的层序遍历
public class P429NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P429NAryTreeLevelOrderTraversal().new Solution();
        // TO TEST
//        Node node1 = new P429NAryTreeLevelOrderTraversal().new Node(1,new ArrayList<>());
//        Node node2 = new P429NAryTreeLevelOrderTraversal().new Node(2,new ArrayList<>());
//        Node node3 = new P429NAryTreeLevelOrderTraversal().new Node(3,new ArrayList<>());
//        Node node4 = new P429NAryTreeLevelOrderTraversal().new Node(4,new ArrayList<>());
//        Node node5 = new P429NAryTreeLevelOrderTraversal().new Node(5,new ArrayList<>());
//        Node node6 = new P429NAryTreeLevelOrderTraversal().new Node(6,new ArrayList<>());
//        node1.children = Arrays.asList(node3,node2,node4);
//        node3.children = Arrays.asList(node5,node6);
        Node node1 = null;
        List<List<Integer>> lists = solution.levelOrder(node1);
        lists.forEach(l -> {
            System.out.println(l);
        });

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        order(Arrays.asList(root),result);
        return result;
    }

    private void order(List<Node> roots,List<List<Integer>> res){
        if (roots == null || roots.size() == 0){
            return;
        }
        res.add(roots.stream().map(e -> e.val).collect(Collectors.toList()));
        List<Node> nextLevel = new ArrayList<>();
        roots.forEach(root -> {
            nextLevel.addAll(root.children);
        });
        order(nextLevel,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
/*
第一遍：
1. 5-15分钟读题思考题目
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