import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.85%)
 * Likes:    1079
 * Dislikes: 0
 * Total Accepted:    319.4K
 * Total Submissions: 697.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 
 * 返回这三个数的和。
 * 
 * 假定每组输入只存在恰好一个解。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        Integer best = null;

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            int leftIdx = i + 1;
            int rightIdx = len - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (leftIdx < rightIdx) {
                int sum = nums[i] + nums[leftIdx] + nums[rightIdx];

                if (sum == target) {
                    return target;
                }

                if (best == null || (Math.abs(target - sum) < Math.abs(target - best))) {
                    best = sum;
                }

                if (sum > target) {
                    // 排除掉相同项
                    while ((leftIdx < rightIdx) && nums[rightIdx - 1] == nums[rightIdx]) {
                        rightIdx--;
                    }
                    rightIdx--;
                } else {
                    // 排除掉相同项
                    while ((leftIdx < rightIdx) && nums[leftIdx + 1] == nums[leftIdx]) {
                        leftIdx++;
                    }
                    leftIdx++;
                }

            }

        }
        return best;
    }
}
// @lc code=end
