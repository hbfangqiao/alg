//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 829 👎 0


package leetcode.editor.cn;

//Java：环形链表
public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        // TO TEST
        ListNode node1 = new P141LinkedListCycle().new ListNode(3);
        ListNode node2 = new P141LinkedListCycle().new ListNode(2);
        ListNode node3 = new P141LinkedListCycle().new ListNode(0);
        ListNode node4 = new P141LinkedListCycle().new ListNode(-4);

        node1.next = node2;
        node2.next = node1;
        node3.next = node4;
        node4.next = node2;
        boolean hasCycle = solution.hasCycle(node1);
        System.out.println(hasCycle);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode fast = head;
            ListNode slow = head;
            do {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            } while (fast != null && fast.next != null);
            return false;
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
    }


/*
第一遍：
1. 5-15分钟读题思考题目 √  （我的思路：使用map记录每个node的值，遍历整个链表）
2. 没有思路则直接看解法，比较解法优劣 √
3. 背诵和默写解法 √
第二遍
1. 马上自己写 -> LeeCode提交 √
2. 多种解法比较，体会 -> 优化 √   注意问题的输入规模
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

我的解答：空间复杂度 O(n) 时间复杂度O(n) 的指针移动操作
public boolean hasCycle(ListNode head) {
    ListNode pointNode = head;
    Map<ListNode,Integer> map = new HashMap<>();
    while (pointNode != null){
        if (map.containsKey(pointNode)){
            return true;
        }
        map.put(pointNode,0);
        pointNode = pointNode.next;
    }
    return false;
}

解法二：快慢指针 时间复杂度O(n) 空间复杂度O(1)
https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/

public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null){
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null){
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}

解法三：利用输入规模最多为10000 时间复杂度O(1) 空间复杂度O(1)
只要执行指针移动操作大于10000就一定存在环

public boolean hasCycle(ListNode head) {
    ListNode pointNode = head;
    int count = 0;
    while (pointNode != null) {
        pointNode = pointNode.next;
        count ++;
        if (count>10000){
            return true;
        }
    }
    return false;
}
*/

}