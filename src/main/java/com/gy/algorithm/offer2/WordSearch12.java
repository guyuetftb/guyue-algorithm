package com.gy.algorithm.offer2;

/**
 * <p> 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * <p> [
 * <p> ["a","b","c","e"],
 * <p> ["s","f","c","s"],
 * <p> ["a","d","e","e"]
 * <p> ]
 *
 * <p> 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * <p>
 * <p> 示例 1：
 * <p> 输入：board =
 * <p> [
 * <p> ["A","B","C","E"],
 * <p> ["S","F","C","S"],
 * <p> ["A","D","E","E"]
 * <p> ]
 * <p> word = "ABCCED"
 * <p> 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p> 输入：
 * <p> board = [
 * <p> ["a","b"],
 * <p> ["c","d"]
 * <p> ], word = "abcd"
 * <p> 输出：false
 * <p>
 * <p>
 * <p> 提示：
 * <p> 1 <= board.length <= 200
 * <p> 1 <= board[i].length <= 200
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 *
 * @author : leelipeng
 * @date : 2021-01-24 11:44
 */
public class WordSearch12 {

    /**
     * 个人: 刚拿到本题, 没有任何思路. 感觉需要有一个地方需要存储走过的格子, 及格子的状态(因为格子只能走一次).
     * <p>
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[3][5];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};
        String word = "ABCCED";
        System.out.println(wordSearch1(board, word));
    }

    /**
     * <p> 本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。
     * <p> 1. 深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     * <p> 2. 剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。
     * <p> DFS 解析：
     * <p> 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     * <p> 终止条件：
     * <p> 返回 false
     * <p>      (1) 行或列索引越界
     * <p>      (2) 当前矩阵元素与目标字符不同
     * <p>      (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
     * <p> 返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
     *
     * <p> 递推工作：
     * <p> 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
     * <p> 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
     * <p> 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
     * <p> 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
     * <p>
     * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean wordSearch1(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        int column = board[0].length; // 横着为宽
        int row = board.length; // 竖着为高
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                boolean res = dfs(board, wordArr, r, c, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int row, int col, int k) {
        if (row < 0 || row >= board.length) {
            // 搜索超出矩阵 row 下标
            return false;
        } else if (col < 0 || col >= board[0].length) {
            // 搜索超出矩阵 column 下标
            return false;
        } else if (board[row][col] != word[k]) {
            // 矩阵元素不等于 字符串元素
            return false;
        }

        // TODO 到这一步
        //  1. 说明在矩阵中搜索的char等于 字符串中的char
        //  2. 同时搜索的字符串长度也已经满足, 说明字符串已经找到.
        if (k == word.length - 1) {
            return true;
        }

        // TODO 到这一步
        //  1. 说明 矩阵中已经搜索到需要的字符.
        //  2. 保存临时字符.
        //  3. 把该位置上的字符设置为#,防止再次查询.
        char tmp = board[row][col];
        board[row][col] = '#';

        // TODO 到这一步
        //  1. 说明 矩阵中已经搜索到需要的字符.
        //  2. 向上, 下, 左, 右同时搜索匹配的字符.
        boolean downRes = dfs(board, word, row + 1, col, k + 1);
        boolean upRes = dfs(board, word, row - 1, col, k + 1);
        boolean rightRes = dfs(board, word, row, col + 1, k + 1);
        boolean leftRes = dfs(board, word, row, col - 1, k + 1);
        boolean res = downRes || upRes || rightRes || leftRes;

        // TODO
        //  把字符设置回去, 下一次迭代使用.
        board[row][col] = tmp;
        return res;
    }

    public static boolean wordSearch2() {
        return false;
    }
}
