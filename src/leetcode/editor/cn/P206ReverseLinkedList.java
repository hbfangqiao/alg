//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1257 👎 0


package leetcode.editor.cn;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
        ListNode node1 = new P206ReverseLinkedList().new ListNode(1);
        ListNode node2 = new P206ReverseLinkedList().new ListNode(2);
        ListNode node3 = new P206ReverseLinkedList().new ListNode(3);
        ListNode node4 = new P206ReverseLinkedList().new ListNode(4);
        ListNode node5 = new P206ReverseLinkedList().new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode reverseNode = solution.reverseList(node1);
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


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur!=null){
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

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
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

解法：
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}
*/


}