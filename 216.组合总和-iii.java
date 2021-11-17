import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (73.69%)
 * Likes:    387
 * Dislikes: 0
 * Total Accepted:    107K
 * Total Submissions: 145.3K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 0, new ArrayList<Integer>(), 1);
        return result;
    }

    private void backtracking(int k, int n, int sum, int recurTime, List<Integer> current, int currentNum) {
        if (sum == n && recurTime == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (recurTime > k || sum > n) {
            return;
        }

        for (int i = currentNum; i < 10; i++) {
            current.add(i);
            backtracking(k, n, sum + i, recurTime + 1, current, i + 1);
            current.remove(current.size() - 1);
        }

    }
}
// @lc code=end
