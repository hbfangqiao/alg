//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i
//]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
// 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 104 
// 0 <= s.length <= 3 * 104 
// 1 <= g[i], s[j] <= 231 - 1 
// 
// Related Topics 贪心算法 
// 👍 286 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：分发饼干
public class P455AssignCookies {
    public static void main(String[] args) {
        Solution solution = new P455AssignCookies().new Solution();
        // TO TEST
        int contentChildren = solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(contentChildren);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int count = 0;
            for (int i = 0; i < s.length && count < g.length; i++) {
                if (s[i] >= g[count]) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
使用 排序+贪心算法 时间复杂度 O(mlogm + nlogn)
注意：饼干不可分，每个小朋友只能拿到1个饼干。所以可以用贪心
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