/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=21908
 *
 * [53] 最大子数组和
 *
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * algorithms
 * Medium (54.77%)
 * Likes:    6072
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 2.6M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 子数组 是数组中的一个连续部分。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * 
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * 
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // int result = Integer.MIN_VALUE;
        // int[][] tmp = new int[nums.length][nums.length];

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         if (i == j) {
        //             tmp[i][j] = nums[i];
        //         }
        //         if (i > 0) {
        //             tmp[i][j] = tmp[i - 1][j] + nums[i];
        //         }
        //         if (j > 0) {
        //             tmp[i][j] = tmp[i][j - 1] + nums[j];
        //         }
        //         if (tmp[i][j] > result) {
        //             result = tmp[i][j];
        //         }
        //     }
        // }
        // return result;
        
        // dp[i] 表示以num[i]结尾的连续子数组的最大和
        // 当dp[i - 1] > 0 时  dp[i] = dp[i - 1] + nums[i]
        // 当dp[i - 1] < 0 时  dp[i] = nums[i]
        // 或者 dp[i] = max{dp[i-1] + nums[i], nums[i]}
        // dp[0] = nums[0]
        // 由于dp[i]的值只和dp[i - 1]有关，所以可以不用数组记住所有状态量
        
        int dp = nums[0];
        int result = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (dp > result) {
                result = dp;
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */

