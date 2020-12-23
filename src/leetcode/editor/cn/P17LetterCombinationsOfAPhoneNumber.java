//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1047 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        List<String> list = solution.letterCombinations("23");
        System.out.println(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<String,String[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return result;
        }
        map.put("2","abc".split(""));
        map.put("3","def".split(""));
        map.put("4","ghi".split(""));
        map.put("5","jkl".split(""));
        map.put("6","mon".split(""));
        map.put("7","pqrs".split(""));
        map.put("8","tuv".split(""));
        map.put("9","wxyz".split(""));
        String[] input = digits.split("");
        dfs(input,new ArrayList<>(),0,result);
        return result;
    }

    private void dfs(String[] input,List<String> path, int level,List<String> result){
        if (input.length == level){
            result.add(getString(path));
            return;
        }
        String tmp = input[level];
        String[] letters = map.get(tmp);
        for (String letter: letters){
            path.add(letter);
            dfs(input,path,level+1,result);
            path.remove(path.size() -1);
        }
    }

    private String getString(List<String> path){
        StringBuilder builder = new StringBuilder();
        path.forEach(e->{
            builder.append(e);
        });
        return builder.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：分治法 和P78 求子集类似 输入 23的话，则填两个空格，2 轮流使用 abc进行填充，3的话轮流使用def填充。
解答成功:
执行耗时:6 ms,击败了27.70% 的Java用户
内存消耗:38.8 MB,击败了19.45% 的Java用户

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