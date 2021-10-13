/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (35.25%)
 * Likes:    3134
 * Dislikes: 0
 * Total Accepted:    847.1K
 * Total Submissions: 2.4M
 * Testcase Example:  '123'
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 123
 * 输出：321
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = -123
 * 输出：-321
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 120
 * 输出：21
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：x = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        while (x != 0) {
            // 由于无法使用64位整型，所以计算Integer.MAX_VALUE来比较
            if ((Integer.MAX_VALUE - x % 10) / 10 < result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (isNegative) {
            return -result;
        }
        return result;
    }
}
// @lc code=end

