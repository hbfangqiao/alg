//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2032 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        String s = "[";
        boolean valid = solution.isValid(s);
        System.out.println("ex: false  ac: "+ valid);
        s = "()[]{}";
        valid = solution.isValid(s);
        System.out.println("ex: true  ac: "+ valid);
        s = "([)]";
        valid = solution.isValid(s);
        System.out.println("ex: false  ac: "+ valid);
        s = "(]";
        valid = solution.isValid(s);
        System.out.println("ex: false  ac: "+ valid);
        s = "()[]{}";
        valid = solution.isValid(s);
        System.out.println("ex: true  ac: "+ valid);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> expect = new Stack<>();
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put('{','}');
            put('(',')');
            put('[',']');
        }};
        for(Character cur : s.toCharArray()){
            if (map.containsKey(cur)) {
                expect.push(map.get(cur));
            }else if (!cur.equals(' ') && (expect.empty() || !expect.pop().equals(cur))){
                return false;
            }
        }
        return expect.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
思路：遍历一遍，碰到左括号，往栈中存入预期的右括号。碰到右括号，看是否和栈中预期的右括号相同
时间复杂度O(n) 空间复杂度 O(n)

第一次提交 结果-解答失败: 未考虑 没有右括号的情况
测试用例:"["
测试结果:true
期望结果:false

第二次提交
执行耗时:3 ms,击败了25.91% 的Java用户
内存消耗:36.6 MB,击败了68.33% 的Java用户

什么题目用栈来解决：
有最近相关性的问题，使用栈来解决。
有顺序性的问题，用queue来解决。

第二遍
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

第一遍，我的解答
public boolean isValid(String s) {
    Stack<Character> expect = new Stack<>();
    Map<Character,Character> map = new HashMap<>();
    map.put('{','}');
    map.put('(',')');
    map.put('[',']');
    Character blank = ' ';
    for (int i = 0; i <s.length() ; i++) {
        Character cur = s.charAt(i);
        if (cur.equals(blank)){
            continue;
        }
        if (map.containsKey(cur)){
            expect.push(map.get(cur));
        }else if (expect.empty() || !expect.pop().equals(cur)){
            return false;
        }
    }
    if (!expect.empty()){//存在未闭合的括号
        return false;
    }
    return true;
}

其他思路：
暴力求解：多次循环 不断得把符合的字符串替换为空，不能替换的时候字符串为空则为true
(({[]})) -> (({})) -> (()) -> () -> 空
时间复杂度O(n^2)
*/
}