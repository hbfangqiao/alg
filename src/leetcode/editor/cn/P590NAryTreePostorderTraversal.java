//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 118 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：N叉树的后序遍历
public class P590NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P590NAryTreePostorderTraversal().new Solution();
        // TO TEST
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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        order(root,result);
        return result;
    }

    private void order(Node root,List<Integer> res){
        if (root == null) {
            return;
        }
        for(Node node: root.children){
            order(node,res);
        }
        res.add(root.val);
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
1. 5-15分钟读题思考题目 √
2. 比较解法优劣 √
我以子节点是否为空作为判断，代码写起来看着很冗余

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

我的解法：
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        order(root.children,result);
        result.add(root.val);
        return result;
    }

    private void order(List<Node> children,List<Integer> res){
        if (children == null || children.size() == 0){
            return;
        }
        children.forEach(e -> {
            order(e.children,res);
            res.add(e.val);
        });
    }


*/
}