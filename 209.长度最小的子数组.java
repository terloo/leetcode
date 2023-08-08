/*
 * @lc app=leetcode.cn id=209 lang=java
 * @lcpr version=21908
 *
 * [209] 长度最小的子数组
 *
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (46.85%)
 * Likes:    1714
 * Dislikes: 0
 * Total Accepted:    544K
 * Total Submissions: 1.2M
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 
 * 
 * 示例 2：
 * 
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int result = 0;
        int sum = nums[0];

        while (i < nums.length) {

            if (i == j) {
                if (sum >= target) {
                    return 1;
                }
            }

            // 如果有满足的数组，则缩小窗口继续寻找
            if (sum >= target) {
                result = j - i + 1;
                sum -= nums[i];
                i++;
                continue;
            }

            // 如果已经有结果，则需要缩小窗口继续寻找
            if (result > 0) {
                sum -= nums[i];
                i++;
            }

            // 如果j越界，说明已经没有剩余数组能比target大了
            j++;
            if (j > nums.length - 1) {
                break;
            }
            sum += nums[j];
        }
        return result;
    }
}
// @lc code=end

/*
// @lcpr case=start
// 7\n[2,3,1,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[1,4,4]\n
// @lcpr case=end

// @lcpr case=start
// 11\n[1,1,1,1,1,1,1,1]\n
// @lcpr case=end

 */
