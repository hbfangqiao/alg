//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 159 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：数组的相对排序
public class P1122RelativeSortArray{
    public static void main(String[] args) {
        Solution solution = new P1122RelativeSortArray().new Solution();
        // TO TEST
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
//        int[] arr1 = {28,6,22,8,44,17};
//        int[] arr2 = {22,28,8,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1,arr2)));//[22,28,8,6,17,44]
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        Integer[] tmp = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (a1, a2) -> {
            if (map.containsKey(a1) && map.containsKey(a2)){
                return map.get(a1) - map.get(a2);
            }
            if (!map.containsKey(a1) && !map.containsKey(a2)){
                return a1 - a2;
            }
            if (map.containsKey(a1) && !map.containsKey(a2)){
                return -1;
            }
            return 1;
        });
        return Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目

arr2 中重新定义了 元素的大小。使用内置的快速排序。重写comparator 方法；O(nlogn)

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