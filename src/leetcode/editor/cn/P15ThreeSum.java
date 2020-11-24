//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2640 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
//        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        int[] input = new int[]{0,0,0,0};
        List<List<Integer>> lists = solution.threeSum(input);
        lists.forEach(e -> {
            System.out.println(e);
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //排序
            Arrays.sort(nums);
            //固定i
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {//大于0跳过
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {//跳过重复的 i
                    continue;
                }
                for (int j = i + 1, k = nums.length - 1; k > j; ) {
                    if (j >= i + 2 && nums[j] == nums[j - 1]) {//跳过重复的j
                        j++;
                        continue;
                    }
                    if (k <= nums.length - 2 && nums[k] == nums[k + 1]) {//跳过重复的k
                        k--;
                        continue;
                    }
                    int tmp = nums[i] + nums[k] + nums[j];
                    if (tmp < 0) {//右侧值偏小
                        j++;
                    } else if (tmp > 0) {//右侧值偏大
                        k--;
                    } else {//正确值
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 -> 暴力解O(n^3)
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

解法一： 暴力求解 O(n^3) 超时
public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);
    for (int i = 0; i <nums.length -2 ; i++) {
        int a1 = nums[i];
        for (int j = i+1; j <nums.length -1 ; j++) {
            int a2 = nums[j];
            for (int k = j+1; k <nums.length ; k++) {
                int a3 = nums[k];
                if (a1 + a2 + a3 == 0){
                    result.add(Arrays.asList(a1,a2,a3));
                }
            }
        }
    }
    return new ArrayList<>(result);
}

解法二：排序+双指针
解题思路：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/

我的代码：
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    //排序
    Arrays.sort(nums);
    //固定i
    for (int i = 0; i < nums.length - 2; i++) {
        if (nums[i] > 0) {//大于0跳过
            continue;
        }
        if (i > 0 && nums[i] == nums[i - 1]) {//跳过重复的 i
            continue;
        }
        for (int j = i + 1, k = nums.length - 1; k > j; ) {
            if (j >= i + 2 && nums[j] == nums[j - 1]) {//跳过重复的j
                j++;
                continue;
            }
            if (k <= nums.length - 2 && nums[k] == nums[k + 1]) {//跳过重复的k
                k--;
                continue;
            }
            int tmp = nums[i] + nums[k] + nums[j];
            if (tmp < 0) {//右侧值偏小
                j++;
            } else if (tmp > 0) {//右侧值偏大
                k--;
            } else {//正确值
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
            }
        }
    }
    return result;
}
*/
}