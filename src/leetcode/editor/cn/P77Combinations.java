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
        dfs(n,k,1,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int n, int k, int begin, List<Integer> path, List<List<Integer>> result){
        if (path.size() == k){//收集到指定个数，则为答案
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n ; i++) {
            path.add(i);
            dfs(n,k,i+1,path,result);
            path.remove(path.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：来自于P22 括号生成。 每层递归将当前所有可能的数填充到 k 长度的 集合中。
解答成功: 执行耗时:457 ms,击败了5.07% 的Java用户 内存消耗:39.7 MB,击败了90.83% 的Java用户
复杂度O(n^k)

2. 比较解法优劣
https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
我的思路和 解法一 基本相同。
我思路多余的地方：
a.但是我是每次使用一个新的list 传入下一层。避免了dfs回头过程中收集结果的数据不准确。
大佬是在dfs 回头的过程中，把当前添加的操作删除。
b.我使用了一个pool 来维护 每层递归可以使用的数。[1 2 3 4] -> [2] 后 我的pool 为 [1,3,4] 其实1完全没必要，
因为已经在 [1 2 3 4] -> [1] 的时候包含了。所以条件简化为 pool 取 比当前取值大的数就可以了。
优化后的代码：
解答成功: 执行耗时:26 ms,击败了29.55% 的Java用户 内存消耗:39.8 MB,击败了84.84% 的Java用户

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

我的题解：
public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new Stack<>();
        for (int i = 0; i <n ; i++) {
            list.add(i+1);
        }
        dfs(list,k,new ArrayList<>(),result);
        return result;
    }

    private void dfs(List<Integer> pool, int k, List<Integer> combine, List<List<Integer>> result){
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
            dfs(nextPool,k,nextCombine,result);
        }

    }
*/
}