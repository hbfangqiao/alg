//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 920 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java：子集
public class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
        List<List<Integer>> subsets = solution.subsets(new int[]{1});
        subsets.forEach(e -> {
            System.out.println(e);
        });
//        System.out.println(subsets);
        System.out.println("");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numList.add(null);
        subsets(numList,0,path,result);
        return result;
    }

    private void subsets(List<Integer> nums,Integer level,List<Integer> path,List<List<Integer>> results){
        if (path.size()>0 && path.get(path.size() -1) == null){
            List<Integer> result = new ArrayList<>(path);
            result.remove(result.size()-1);
            results.add(result);
            return;
        }
        if (nums.size() - 1 == path.size()){
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = level; i <nums.size() ; i++) {//这里从level开始遍历，前面的值已经被使用了，确保不重复
            Integer num = nums.get(i);
            path.add(num);
            subsets(nums,i+1,path,results);//这里level值 是 i+1 使用2的时候1已经在前面遍历过了。避免重复
            path.remove(num);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：在nums的基础上 使用一个 null 进行填充。如果发现是null则停止填充结果。

解答成功:
执行耗时:2 ms,击败了19.80% 的Java用户
内存消耗:38.8 MB,击败了70.42% 的Java用户

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