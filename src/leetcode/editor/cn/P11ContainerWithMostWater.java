//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1880 👎 0


package leetcode.editor.cn;

//Java：盛最多水的容器
public class P11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new P11ContainerWithMostWater().new Solution();
        // TO TEST
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(input);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int bottom = j-i;
                int minHeight = height[i] < height[j] ? height[i++] : height[j--];
                maxArea = Math.max(maxArea,minHeight * bottom);
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
/*
第一遍：
1. 5-15分钟读题思考题目  -> 暴力求解 √
2. 没有思路则直接看解法，比较解法优劣 √
3. 背诵和默写解法 √
第二遍
1. 马上自己写 -> LeeCode提交  √
2. 多种解法比较，体会 -> 优化  √
第三遍
1. 过了一天后重复练习相同题目
第四遍
1. 过了一周重复练习
第五遍
1. 面试前一周重复练习

第一遍暴力求解代码：时间复杂度 O(n^2)
public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i <height.length-1 ; i++) {
        int heightLeft = height[i];
        for (int j = i+1; j < height.length; j++) {
            int heightRight = height[j];
            int bottom = j-i;
            int minheight = heightLeft > heightRight ? heightRight : heightLeft;
            int area = minheight * bottom;
            if (area > maxArea){
                maxArea = area;
            }
        }
    }
    return maxArea;
}

第二遍 双指针解法 O(n)
左右指针向中间收敛，宽度逐渐减少，依次移动较小的指针

public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0, j = height.length - 1; i < j; ) {
        int bottom = j-i;
        int minHeight = height[i] < height[j] ? height[i++] : height[j--];
        maxArea = Math.max(maxArea,minHeight * bottom);
    }
    return maxArea;
}

双指针解法的正确性证明：
https://leetcode-cn.com/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
*/
