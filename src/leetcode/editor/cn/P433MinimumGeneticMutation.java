//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2

// "AACCGGTT" "AAACGGTA" ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"] 返回4
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 63 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：最小基因变化
public class P433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();
        // TO TEST
        // "AACCGGTT" "AAACGGTA" ["AACCGATT","AACCGATA","AAACGATA","AAACGGTA"]
        int i = solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            HashSet<String> set = new HashSet<String>(Arrays.asList(bank));
            if (!set.contains(end)){
                return -1;
            }
            char[] four = {'A', 'C', 'G', 'T'};
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);
            set.remove(start);
            int step = 0;
            while (!queue.isEmpty()){
                int n = queue.size();
                step++;
                for (int i = 0; i <n ; i++) {
                    char[] tmpchars = queue.poll().toCharArray();
                    for (int index = 0; index < tmpchars.length; index++) {
                        char old = tmpchars[index];
                        for (int j = 0; j < 4; j++) {
                            tmpchars[index] = four[j];
                            String newString = new String(tmpchars);
                            if (end.equals(newString)){
                                return step;
                            }else if(set.contains(newString)){
                                set.remove(newString);
                                queue.add(newString);
                            }
                        }
                        tmpchars[index] = old;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
2. 没有思路则直接看解法，比较解法优劣
没有读懂题目，开始认为由 start -> end 的 最小基因变化就是 字符不同的位数。不需要进行计算。没有考虑到 bank中是否有可以变化过去的路线
BFS：针对 AACCGGTT start, 针对每一层。 依次将 每一位候补对象每一位 替换成ACGT 判断是否在bank中。
如果存在则替换。进入下一层。直到找到 和end相同的结果

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