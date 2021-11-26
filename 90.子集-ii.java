import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (63.38%)
 * Likes:    694
 * Dislikes: 0
 * Total Accepted:    148.3K
 * Total Submissions: 234K
 * Testcase Example:  '[1,2,2]'
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums, 0, new LinkedList<>());
        return result;
    }

    private List<List<Integer>> result = new LinkedList<>();

    private void backTrace(int[] nums, int start, LinkedList<Integer> current) {
        result.add(new ArrayList<>(current));
        if (start == nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backTrace(nums, i + 1, current);
            current.removeLast();
            while (i + 1 < nums.length && nums[i] == nums[i + 1])
                i++;
        }
    }
}
// @lc code=end

