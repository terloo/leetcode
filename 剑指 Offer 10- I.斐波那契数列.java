/*
 * @lc app=leetcode.cn id=剑指 Offer 10- I lang=java
 * @lcpr version=21907
 *
 * [剑指 Offer 10- I] 斐波那契数列
 *
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/
 *
 * LCOF
 * Easy (35.96%)
 * Likes:    479
 * Dislikes: 0
 * Total Accepted:    482.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '0'
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * 
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 2
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 5
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        final long mod = 1000000007;

        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int result = -1;

        for (int i = 0; i < n - 1; i++) {
            result = a + b;
            result %= mod;
            a = b;
            b = result;
        }
        return result;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 5\n
// @lcpr case=end

 */
