//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 643 👎 0


package leetcode.editor.cn;

//Java：两两交换链表中的节点
public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        ListNode node1 = new P24SwapNodesInPairs().new ListNode(1);
        ListNode node2 = new P24SwapNodesInPairs().new ListNode(2);
        ListNode node3 = new P24SwapNodesInPairs().new ListNode(3);
        ListNode node4 = new P24SwapNodesInPairs().new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(node1);
        System.out.println();
        // TO TEST
        ListNode swapNode = solution.swapPairs(node1);
        print(swapNode);
    }

    private static void print(ListNode swapNode) {
        while (swapNode != null) {
            System.out.print(swapNode.val);
            System.out.print("->");
            if (swapNode.next == null) {
                System.out.print("null");
            }
            swapNode = swapNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode temp = pre;

            while (temp.next != null && temp.next.next != null) {
                ListNode first = temp.next;
                ListNode second = temp.next.next;
                temp.next = second;
                first.next = second.next;
                second.next = first;
                temp = first;
            }
            return pre.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

/*
第一遍：
1. 5-15分钟读题思考题目 √ 懵逼
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
https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
解法一：递归
递归写法要观察本级递归的解决过程，形成抽象模型。
因为递归本质就是不断重复相同的事情。而不是去思考完整的调用栈，一级又一级，无从下手

关注点有三：
返回值：递归完成后的子链表
调用单元：交换head 和 next
终止条件：head 或者 next 任意一个为null

public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode newHeadNode = head.next;
    head.next = swapPairs(newHeadNode.next);
    newHeadNode.next = head;
    return newHeadNode;
}

解法二：遍历


*/
}