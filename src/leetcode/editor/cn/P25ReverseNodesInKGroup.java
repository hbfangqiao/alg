//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 770 👎 0


package leetcode.editor.cn;
//Java：K 个一组翻转链表
public class P25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        // TO TEST
        ListNode node1 = new P25ReverseNodesInKGroup().new ListNode(1);
        ListNode node2 = new P25ReverseNodesInKGroup().new ListNode(2);
        ListNode node3 = new P25ReverseNodesInKGroup().new ListNode(3);
        ListNode node4 = new P25ReverseNodesInKGroup().new ListNode(4);
        ListNode node5 = new P25ReverseNodesInKGroup().new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode reverseNode = solution.reverseKGroup(node1, 5);
        while (reverseNode != null) {
            System.out.print(reverseNode.val);
            System.out.print("->");
            if (reverseNode.next == null){
                System.out.print("null");
            }
            reverseNode = reverseNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //判断是否需要翻转-终止条件
        ListNode pos = head;
        for (int i = 0; i <k ; i++) {
            if (pos==null){//不足k个
                return head;
            }
            pos = pos.next;
        }
        //翻转链表的k个节点
        ListNode pre = reverseKGroup(pos,k);
        ListNode cur = head;
        for (int i = 0; i <k ; i++) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

/*
第一遍：
1. 5-15分钟读题思考题目 √ 有思路，采用递归，每个递归进行翻转链表。跳出条件为 节点数目不够。返回值为新的头节点
2. 没有思路则直接看解法，比较解法优劣 √ 其它人的解法看起来有些复杂，我的代码相对简单
3. 背诵和默写解法 √ 提交通过
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
public ListNode reverseKGroup(ListNode head, int k) {
    //判断是否需要翻转-终止条件
    ListNode pos = head;
    for (int i = 0; i <k ; i++) {
        if (pos==null){//不足k个
            return head;
        }
        pos = pos.next;
    }
    //翻转链表的k个节点
    ListNode pre = reverseKGroup(pos,k);
    ListNode cur = head;
    for (int i = 0; i <k ; i++) {
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
    }
    return pre;
}

*/
}