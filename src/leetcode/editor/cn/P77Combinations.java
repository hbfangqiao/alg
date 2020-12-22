//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 459 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        List<List<Integer>> combine = solution.combine(4, 2);
        combine.forEach(e -> {
            System.out.println(e);
        });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new Stack<>();
        for (int i = 0; i <n ; i++) {
            list.add(i+1);
        }
        generate(list,k,new ArrayList<>(),result);
        return result;
    }

    private void generate(List<Integer> pool, int k, List<Integer> combine, List<List<Integer>> result){
        if (combine.size() > k){//结束条件，个数收集完毕
            return;
        }
        if (combine.size() == k){//收集到指定个数，则为答案
            result.add(combine);
            return;
        }
        for (int i = 0; i <pool.size() ; i++) {//当pool维护 当前层，可用的数据 避免出现 [1,1]的情况
            List<Integer> nextCombine = new ArrayList<>(combine);
            if (nextCombine.size()>0 && nextCombine.get(nextCombine.size()-1) > pool.get(i)){//保证 搜集的结果升序排列,避免[1,2],[2,1]
                continue;
            }
            nextCombine.add(pool.get(i));
            List<Integer> nextPool = new ArrayList<>(pool);
            nextPool.remove(i);//已经使用的数不再使用
            generate(nextPool,k,nextCombine,result);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：来自于P22 括号生成。 每层递归将当前所有可能的数填充到 k 长度的 集合中。
解答成功: 执行耗时:457 ms,击败了5.07% 的Java用户 内存消耗:39.7 MB,击败了90.83% 的Java用户
分析是过程中存在大量的 list copy 所以很慢

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