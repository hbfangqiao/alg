//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 545 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：全排列 II
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        lists.forEach(e -> {
            System.out.println(e);
        });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        List<Integer> numList = new ArrayList<>();
        for (int i: nums) {
            numList.add(i);
        }
        generate(numList,path,result);
        return result;
    }

    private void generate(List<Integer> nums,List<Integer> path,List<List<Integer>> result){
        if (path.size() == nums.size()){
            result.add(new ArrayList<>(path));
            return;
        }
        //移除已经在path中的元素，不重复使用
        path.forEach(e-> {
            nums.remove(e);
        });
        Set<Integer> numSet = new HashSet<>(nums);//当前可遍历的
        path.forEach(e -> {
            nums.add(e);
        });
        numSet.forEach(el -> {
            path.add(el);
            generate(nums,path,result);
            path.remove(path.size() -1);
        });
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
我的思路：每层递归，将已经使用的元素移除，并把剩下的元素使用set去重。依次塞入path
解答成功: 执行耗时:13 ms,击败了17.08% 的Java用户 内存消耗:39.3 MB,击败了75.10% 的Java用户
移除过程中创建集合后，内存消耗降低
解答成功: 执行耗时:11 ms,击败了17.34% 的Java用户  内存消耗:39.1 MB,击败了93.49% 的Java用户

2. 比较解法优劣
https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
大佬在进行遍历之前，将集合进行排序。这样就可以通过一个简单的条件 i > 0 && nums[i] == nums[i - 1] && !used[i - 1] 来判断

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