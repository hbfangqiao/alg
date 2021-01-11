//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9289 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//Java：两数之和
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
//        int[] result = solution.twoSum(new int[]{3, 2, 6}, 6);
        System.out.println(Arrays.toString(result));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i <nums.length ; i++) {
                if (map.get(target - nums[i]) != null){
                    return new int[]{i,map.get(target - nums[i])};
                }
                map.put(nums[i],i);
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 --> 暴力解 O(n^2) √
2. 没有思路则直接看解法，比较解法优劣  √
3. 背诵和默写解法 √
第二遍
1. 马上自己写 -> LeeCode提交 √
2. 多种解法比较，体会 -> 优化
第三遍
1. 过了一天后重复练习相同题目 √
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习	

暴力解：O(n^2)
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length-1; i++) {
        int a1 = nums[i];
        for (int j = i+1; j <nums.length ; j++) {
            int a2 = nums[j];
            if (a1 + a2 == target){
                return new int[]{i,j};
            }
        }
    }
    return new int[]{};
}

hash 表加速:O(n)
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.get(target - nums[i]) != null){
            return new int[]{i,map.get(target - nums[i])};
        }
        map.put(nums[i],i);
    }
    return new int[]{};
}

*/

}