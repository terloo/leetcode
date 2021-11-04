import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (72.78%)
 * Likes:    1611
 * Dislikes: 0
 * Total Accepted:    353.8K
 * Total Submissions: 486.3K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target
 * 的唯一组合。
 * 
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 示例 3：
 * 
 * 
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * candidate 中的每个元素都是独一无二的。
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.target = target;
        search(new ArrayList<>(), candidates, 0, 0);
        return results;
    }

    private int target;
    private List<List<Integer>> results = new LinkedList<>();

    private void search(List<Integer> result, int[] candidates, int sum, int idx) {
        for (int i = idx; i < candidates.length; i++) {
            if (sum == target) {
                results.add(new ArrayList<>(result));
                return;
            }
            if (sum > target) {
                return;
            }

            result.add(candidates[i]);
            // 搜索完包含了candidates[idx]的元素后，就要在后续的搜索中剔除掉该元素防止重复
            // 所以下次搜索应该从i开始而不是0
            search(result, candidates, sum + candidates[i], i);
            result.remove(result.size() - 1);
        }
    }
}
// @lc code=end

