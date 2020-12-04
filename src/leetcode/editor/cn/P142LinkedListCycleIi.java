//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 726 👎 0


package leetcode.editor.cn;

//Java：环形链表 II
public class P142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // TO TEST
        // TO TEST
        ListNode node1 = new P142LinkedListCycleIi().new ListNode(3);
        ListNode node2 = new P142LinkedListCycleIi().new ListNode(2);
        ListNode node3 = new P142LinkedListCycleIi().new ListNode(0);
        ListNode node4 = new P142LinkedListCycleIi().new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode listNode = solution.detectCycle(node1);
        System.out.println(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null){
                return null;
            }
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while (fast != slow){
                if (fast == null || fast.next == null){
                    return null;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
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
1. 5-15分钟读题思考题目 √  map记录每个节点比较
2. 没有思路则直接看解法，比较解法优劣  √
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

我的：时间复杂度O(n) 空间复杂度O(n)
public ListNode detectCycle(ListNode head) {
    ListNode pointNode = head;
    Set<ListNode> set = new HashSet<>();
    while (pointNode != null) {
        if (set.contains(pointNode)) {
            return pointNode;
        }
        set.add(pointNode);
        pointNode = pointNode.next;
    }
    return null;
}

最优解：时间复杂度O(n) 空间复杂度O(1)
https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/

我的代码：乱七八糟，不清晰 =。=！
public ListNode detectCycle(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    boolean secondRound = false;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        if (secondRound){
            fast = fast.next;
        }else {
            fast = fast.next.next;
        }
        if (slow == fast){
            fast = head;
            if (head == slow || secondRound){ // head==slow 表示第一次相遇就在表头
                return slow;
            }
            secondRound = true;
        }
    }
    return null;
}

示例代码：
ListNode fast = head, slow = head;
    while (true) {
        if (fast == null || fast.next == null) return null;
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) break;
    }
    fast = head;
    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
}

*/
}