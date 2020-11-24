//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 750 👎 0


package leetcode.editor.cn;

import java.util.Arrays;


//Java：移动零
public class P283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int[] input = new int[]{0,1,0,3,12};
        solution.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]!=0){
                    swap(i,j,nums);
                    j++;
                }
            }
        }

        private void swap(int i, int j, int[] nums) {
            int z=0;
            z = nums[i];
            nums[i] = nums[j];
            nums[j] = z;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 知识点：一维数组的坐标变换

 第一遍
 1. 5-15分钟读题思考题目 √
 2. 没有思路则直接看解法，比较解法优劣 √
 3. 背诵和默写解法 √
 第二遍
 1. 马上自己写 -> LeeCode提交 g√
 2. 多种解法比较,理解其他人的思路
 第三遍
 1.


 最优解 时间复杂度 O(n)

 给出的最优解——使用j下标记录下次要交换0的位置
 [0,1,0,3,12]  j=0
    ↓
 [1,1,0,3,12]   发现 1 和 下标j进行交换，
    ↓
 [1,0,0,3,12]  j=1
    ↓
 [1,3,0,3,12]   发现 3 和 下标j 进行交换
    ↓
 [1,3,0,0,12]  j=2
    ↓
 [1,3,12,0,12]  发现12和 下标j进行交换
    ↓
 [1,3,12,0,0]

 public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i];
            if (i != j) {
                nums[i] = 0;
            }
            j++;
        }

    }
 }

 快慢指针的思路：
 i 快指针能飞,
 j 慢指针不能飞，
 非0是 河流, 其它数是陆地。j碰到0了跑不过去，需要i把陆地搬过，才能跑过去
i------>i
j------>j
1 3 3 5 0 1 0 3 8

 i移动陆地帮助j继续前进
i------>i~~i
j------>j
1 3 3 5 0 1 0 3 8

i------>i~~i
j------>j
1 3 3 5 1 0 0 3 8

i------>i~~~~~i
j-------->j
1 3 3 5 1 0 0 3 8

i------>i~~~~~i
j-------->j
1 3 3 5 1 3 0 0 8

i------>i~~~~~~~i
j---------->j
1 3 3 5 1 3 0 0 8

 i------>i~~~~~~~i
 j---------->j
 1 3 3 5 1 3 8 0 0
 */
