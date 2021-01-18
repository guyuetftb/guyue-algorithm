package com.gy.algorithm.leetcode.string;

/**
 * Friendship is a sheltering tree.
 *
 * @author : guyuetftb
 * @date : 2020-11-18 19:54
 */
public class LC125StringIsPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hello -> " + isPalindrome("hello"));
        System.out.println("abc8cba -> " + isPalindrome("abc8cba"));
    }

    public static boolean isPalindrome(String str) {
        char[] charArr = str.toCharArray();
        int head = 0;
        int tail = str.length() - 1;
        while (head < tail) {
            if (charArr[head] == charArr[tail]) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }
}
