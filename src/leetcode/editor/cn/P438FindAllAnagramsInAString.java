//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 503 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));// 0 6
        System.out.println(solution.findAnagrams("abab","ab"));// 0 1 2
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()){
            return result;
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        char[] tmp = new char[pChars.length];
        for (int i = p.length() - 1; i < sChars.length ; i++) {
            //0 1 2
            for (int j = 0; j <tmp.length ; j++) {
                tmp[j] = sChars[i - j];
            }
            Arrays.sort(tmp);
            if (Arrays.equals(tmp,pChars)){
                result.add(i - pChars.length + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
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

我的解法一：时间复杂度 O(N*M) N M 为两个字符串的长度
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0 || s.length() < p.length()){
        return result;
    }
    char[] sChars = s.toCharArray();
    char[] pChars = p.toCharArray();
    Arrays.sort(pChars);
    char[] tmp = new char[pChars.length];
    for (int i = p.length() - 1; i < sChars.length ; i++) {
        //0 1 2
        for (int j = 0; j <tmp.length ; j++) {
            tmp[j] = sChars[i - j];
        }
        Arrays.sort(tmp);
        if (Arrays.equals(tmp,pChars)){
            result.add(i - pChars.length + 1);
        }
    }
    return result;
}
*/
}