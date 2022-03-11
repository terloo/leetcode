import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (39.55%)
 * Likes:    1006
 * Dislikes: 0
 * Total Accepted:    236.3K
 * Total Submissions: 597.9K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        search(nums, 0, target, new ArrayList<>(), 0);

        return result;
    }

    private void search(int[] nums, int startIndex, int target, List<Integer> currentNum, int currentSum) {
        if (currentNum.size() == 4) {
            if (currentSum == target) {
                result.add(new LinkedList<>(currentNum));
            }
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            currentNum.add(nums[i]);
            currentSum += nums[i];
            search(nums, i + 1, target, currentNum, currentSum);
            currentNum.remove(currentNum.size() - 1);
            currentSum -= nums[i];
        }
    }
}
// @lc code=end
