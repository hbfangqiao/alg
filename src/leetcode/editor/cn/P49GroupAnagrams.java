//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 606 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：字母异位词分组
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(s);
        lists.forEach(l -> {
            System.out.println(l);
        });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] carray = s.toCharArray();
            Arrays.sort(carray);
            String key = new String(carray);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
绕到了判断两个数是否是异位词的坑中

2. 没有思路则直接看解法，比较解法优劣
1.hash + 排序法  O(nklogk)
2.hash + 计数法 O(n(k + |Σ|))

3. 背诵和默写解法 √排序法
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