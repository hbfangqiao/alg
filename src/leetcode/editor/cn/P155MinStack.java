//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 746 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//Java：最小栈
public class P155MinStack{
    public static void main(String[] args) {
        MinStack minStack = new P155MinStack().new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();//
        System.out.println(minStack.top());     // --> 返回 0.
        System.out.println(minStack.getMin());  // --> 返回 -2.
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }
    
    public void pop() {
        Integer pop = stack.pop();
        if (minStack.peek().equals(pop)){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
思路：在pop  的时候 进行遍历，找出其中的最小值。以此通过常数时间获得最小值

解答成功:
执行耗时:9 ms,击败了17.83% 的Java用户
内存消耗:40.1 MB,击败了82.55% 的Java用户

2. 比较解法优劣
提供了 1.辅助栈，2.每个node上面保持最小值  两种方法
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

我的题解：push O(1) pop O(n) top O(1) getMin O(1)
class MinStack {

    private Deque<Integer> deque;
    private Integer min;

    public MinStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.push(x);
        if (min == null || x < min){
            min = x;
        }
    }

    public void pop() {
        Integer i = deque.pop();
        if (i.equals(min)){
            min = null;
            deque.forEach(e -> {
                if (min == null || e < min){
                    min = e;
                }
            });
        }
        if (deque.isEmpty()){
            min = null;
        }
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return min;
    }
}

解法一：辅助栈

*/
}