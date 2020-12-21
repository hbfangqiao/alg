//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 430 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的序列化与反序列化
public class P297SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        // TO TEST
        TreeNode node1 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(1);
        TreeNode node2 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(2);
        TreeNode node3 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(3);
        TreeNode node4 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(4);
        TreeNode node5 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(5);
        TreeNode node6 = new P297SerializeAndDeserializeBinaryTree().new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        node4.right = node6;
        Codec codec = new P297SerializeAndDeserializeBinaryTree(). new Codec();
        String s = codec.serialize(node1);
        System.out.println(s);//1,2,None,None,3,4,None,None,5,None,None,

        TreeNode deserialize = codec.deserialize(s);
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
public class Codec {

    public String serialize(TreeNode root) {
        return rserialize(root, new StringBuilder("")).toString();
    }

    public StringBuilder rserialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("None,");
        } else {
            builder.append(root.val + ",");
            builder.append(rserialize(root.left,new StringBuilder("")));
            builder.append(rserialize(root.right,new StringBuilder("")));
        }
        return builder;
    }

    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    public TreeNode rdeserialize(List<String> list) {
        if (list.get(0).equals("None")){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = rdeserialize(list);
        node.right = rdeserialize(list);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
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
2. 没有思路则直接看解法，比较解法优劣
已看  DFS 前序遍历解法 O(n)

3. 背诵和默写解法 √
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