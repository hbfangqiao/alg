//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 320 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：单词搜索 II
public class P212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new P212WordSearchIi().new Solution();
        // TO TEST
        char[][] board = new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'},
        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> result = solution.findWords(board, words);
        result.forEach(System.out::println);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            //构建Trie
            Trie trie = new Trie();
            for (String word : words){
                trie.insert(word);
            }
            Set<String> results = new HashSet<>();
            for (int i = 0; i <board.length ; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    if (trie.root.children.containsKey(board[i][j])){
                        dfs(board,i,j,results,trie.root.children.get(board[i][j]));
                    }
                }
            }
            return new ArrayList<>(results);
        }

        public void dfs(char[][] board,int x,int y,Set<String> results,TrieNode trieNode){
            if (trieNode.word!=null){
                results.add(trieNode.word);
            }
            //DFS 搜索board
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            char old = board[x][y];
            board[x][y] = '@';
            for (int i = 0; i <4 ; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length){
                    continue;
                }
                if (trieNode.children.containsKey(board[newX][newY])){
                    dfs(board,newX,newY,results,trieNode.children.get(board[newX][newY]));
                }
            }
            board[x][y] = old;
        }
    }

    class Trie{
        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            for (int i = 0; i <word.length() ; i++) {
                char c = word.charAt(i);
                if (node.children.containsKey(c)){
                    node = node.children.get(c);
                }else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c,newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
    }

    class TrieNode {
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public String word = null;
    }
//leetcode submit region end(Prohibit modification and deletion)

/*
第一遍：
1. 5-15分钟读题思考题目 √
傻搜法
2. 没有思路则直接看解法，比较解法优劣
Tire+DFS
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