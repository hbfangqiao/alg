//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 315 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：有效的字母异位词
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s,t));
        s = "rat";
        t = "car";
        System.out.println(solution.isAnagram(s,t));
        s = "a";
        t = "ab";
        System.out.println(solution.isAnagram(s,t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!= t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
循环s 将每个字符存入map，value记录出现次数  循环t依次从map中取出字符，最后map为空即为字母异位词
两次通过：执行耗时:16 ms,击败了20.17% 的Java用户 内存消耗:39.3 MB,击败了13.51% 的Java用户

优化写法后
解答成功: 执行耗时:14 ms,击败了22.19% 的Java用户 内存消耗:39 MB,击败了26.92% 的Java用户

2. 看解法，比较解法优劣
暴力解：先sort再equal O(nlogn)
hash: 统计每个字符出现的次数 O(n)

3. 背诵和默写解法
第二遍 √
1. 马上自己写 -> LeeCode提交
2. 多种解法比较，体会 -> 优化
第三遍 √
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

四步法：
1. 和面试官讨论确认清楚
2. 列出可能的题解，并给出其中的最优解
3. 写代码
4. 阐述测试用例


我的解法：
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()){
        return false;
    }
    Map<Character,Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()){
        map.put(c,map.getOrDefault(c,0) + 1);
    }
    for (Character c : t.toCharArray()){
        map.put(c,map.getOrDefault(c,0) - 1);
        if (map.get(c) < 0){
            return false;
        }
    }
    return true;
}
*/
}