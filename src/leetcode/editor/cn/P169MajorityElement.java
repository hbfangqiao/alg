//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 824 👎 0


package leetcode.editor.cn;

//Java：多数元素
public class P169MajorityElement{
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
        int i = solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    private int dfs(int[] nums,int left,int right){
        if (left == right){
            return nums[left];
        }
        int mid = (right - left)/2 + left;
        int leftVal = dfs(nums,left,mid);
        int rightVal = dfs(nums,mid+1,right);
        if (leftVal == rightVal){
            return leftVal;
        }
        int leftValCount = count(nums,leftVal,left,right);
        int rightValCount = count(nums,rightVal,left,right);
        return leftValCount > rightValCount ? leftVal:rightVal;
    }

    private int count(int[] nums,int num,int left,int right){
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (num == nums[i]){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目
Hash表统计个数：O(n)
解答成功:
执行耗时:13 ms,击败了32.21% 的Java用户
内存消耗:44 MB,击败了10.33% 的Java用户

2. 比较解法优劣
分治法： O（nlogn）
解答成功:
执行耗时:859 ms,击败了5.84% 的Java用户
内存消耗:41.7 MB,击败了71.28% 的Java用户
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

我的题解（Hash表统计个数）
public int majorityElement(int[] nums) {
    Map<Integer,Integer> map = new HashMap<>();
    for (Integer num : nums){
        Integer count = map.getOrDefault(num,0);
        map.put(num,++count);
    }
    List<Integer> res = new ArrayList<>();
    map.forEach((k,v)->{
        if (v > nums.length /2){
            res.add(k);
        }
    });
    return res.get(0);
}
*/
}