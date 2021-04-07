//给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。 
//
// J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。 
//
// 示例 1: 
//
// 输入: J = "aA", S = "aAAbbbb"
//输出: 3
// 
//
// 示例 2: 
//
// 输入: J = "z", S = "ZZ"
//输出: 0
// 
//
// 注意: 
//
// 
// S 和 J 最多含有50个字母。 
// J 中的字符不重复。 
// 
// Related Topics 哈希表 
// 👍 634 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：宝石与石头
public class P771JewelsAndStones{
    public static void main(String[] args) {
        Solution solution = new P771JewelsAndStones().new Solution();
        // TO TEST
        System.out.println(solution.numJewelsInStones("aA","aAAbbbb"));
        System.out.println(solution.numJewelsInStones("z","ZZ"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet jSet = new HashSet();
        int result = 0;
        char[] jarray = jewels.toCharArray();
        char[] sarray = stones.toCharArray();
        for(char ch : jarray){
           jSet.add(ch);
        }
        for (int i = 0; i <sarray.length ; i++) {
            if (jSet.contains(sarray[i])){
                result ++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

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
*/
}