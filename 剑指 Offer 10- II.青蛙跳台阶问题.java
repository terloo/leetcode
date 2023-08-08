/*
 * @lc app=leetcode.cn id=剑指 Offer 10- II lang=java
 * @lcpr version=21908
 *
 * [剑指 Offer 10- II] 青蛙跳台阶问题
 *
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/
 *
 * LCOF
 * Easy (45.75%)
 * Likes:    392
 * Dislikes: 0
 * Total Accepted:    377.5K
 * Total Submissions: 825.1K
 * Testcase Example:  '0'
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 
 * 示例 1：
 * 
 * 输入：n = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 7
 * 输出：21
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 0
 * 输出：1
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 100
 * 
 * 
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numWays(int n) {
        final int mod = 1000000007;

        // f[n] = f[n - 1] + f[n - 2];
        // f[0] = 1
        // f[1] = 2
        if (n == 0) {
            return 1;
        }

        if (n <= 2) {
            return n;
        }

        int[] tmp = new int[n];
        tmp[0] = 1;
        tmp[1] = 2;


        for (int i = 2; i < tmp.length; i++) {
            tmp[i] = (tmp[i - 1] + tmp[i - 2]) % mod;
        }

        return tmp[n - 1];

    }
}
// @lc code=end

/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 7\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

 */
