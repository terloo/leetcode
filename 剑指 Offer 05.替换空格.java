/*
 * @lc app=leetcode.cn id=剑指 Offer 05 lang=java
 * @lcpr version=21908
 *
 * [剑指 Offer 05] 替换空格
 *
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/description/
 *
 * LCOF
 * Easy (75.32%)
 * Likes:    487
 * Dislikes: 0
 * Total Accepted:    655.2K
 * Total Submissions: 869.9K
 * Testcase Example:  '"We are happy."'
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 
 * 
 * 
 * 限制：
 * 
 * 0 <= s 的长度 <= 10000
 * 
 */

// @lc code=start

class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();

        char[] stringBytes = s.toCharArray();
        for (int i = 0; i < stringBytes.length; i++) {
            if (stringBytes[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(stringBytes[i]);
            }
        }

        return sb.toString();
    }
}
// @lc code=end

/*
// @lcpr case=start
// "We are happy."\n
// @lcpr case=end

 */
