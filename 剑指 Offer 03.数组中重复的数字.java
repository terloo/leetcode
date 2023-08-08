/*
 * @lc app=leetcode.cn id=剑指 Offer 03 lang=java
 * @lcpr version=21908
 *
 * [剑指 Offer 03] 数组中重复的数字
 *
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/description/
 *
 * LCOF
 * Easy (67.13%)
 * Likes:    1173
 * Dislikes: 0
 * Total Accepted:    741.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2, 3, 1, 0, 2, 5, 3]'
 *
 * 找出数组中重复的数字。
 * 
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * 示例 1：
 * 
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 * 
 * 
 * 
 * 
 * 限制：
 * 
 * 2 <= n <= 100000
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> tmpSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (tmpSet.contains(nums[i])) {
                return nums[i];
            }
            tmpSet.add(nums[i]);
        }
        throw new RuntimeException("error");
    }
}
// @lc code=end

/*
// @lcpr case=start
// [2, 3, 1, 0, 2, 5, 3]\n
// @lcpr case=end

 */
