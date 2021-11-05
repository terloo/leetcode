import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (33.64%)
 * Likes:    3944
 * Dislikes: 0
 * Total Accepted:    693.9K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
 * 且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^5 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        // 先把原数组排序
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        // i为头指针
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return results;
            }
            // 排除头指针重复的情况
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // 左指针为i + 1  右指针为数组末尾
            int lIdx = i + 1;
            int rIdx = nums.length - 1;

            while (lIdx < rIdx) {
                int sum = nums[lIdx] + nums[rIdx] + nums[i];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[lIdx], nums[rIdx]));
                    // 继续排除左右有重复的情况
                    while (lIdx < rIdx && nums[lIdx + 1] == nums[lIdx])
                        lIdx++;
                    while (lIdx < rIdx && nums[rIdx - 1] == nums[rIdx])
                        rIdx--;
                    // 排除完成将左右指针向右左拨动一位继续寻找
                    lIdx++;
                    rIdx--;

                } else if (sum > 0) {
                    rIdx--;
                } else {
                    lIdx++;
                }
            }
        }
        return results;

    }

}
// @lc code=end
