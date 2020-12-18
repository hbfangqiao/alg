//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 122 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
        Node node1 = new P589NAryTreePreorderTraversal().new Node(1,new ArrayList<>());
        Node node2 = new P589NAryTreePreorderTraversal().new Node(2,new ArrayList<>());
        Node node3 = new P589NAryTreePreorderTraversal().new Node(3,new ArrayList<>());
        Node node4 = new P589NAryTreePreorderTraversal().new Node(4,new ArrayList<>());
        Node node5 = new P589NAryTreePreorderTraversal().new Node(5,new ArrayList<>());
        Node node6 = new P589NAryTreePreorderTraversal().new Node(6,new ArrayList<>());
        node1.children = Arrays.asList(node3,node2,node4);
        node3.children = Arrays.asList(node5,node6);
        List<Integer> preorder = solution.preorder(node1);
        System.out.println(preorder);

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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        order(root,list);
        return list;
    }

    private void order(Node root,List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        for (Node node : root.children){
            order(node,res);
        }
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