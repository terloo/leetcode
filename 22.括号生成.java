import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.27%)
 * Likes:    2132
 * Dislikes: 0
 * Total Accepted:    369.7K
 * Total Submissions: 478.4K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        num = n;
        back(n * 2, 0, 0);

        return results;
    }

    String lBrackets = "(";
    String rBrackets = ")";

    private int num;

    private List<String> results = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    private void back(int n, int lNum, int rNum) {
        if (!valid(lNum, rNum)) {
            return;
        }
        if (n == 0) {
            if (lNum == num && rNum == num) {
                results.add(String.join("", result));
            }
            return;
        }

        result.add(lBrackets);
        back(n - 1, lNum + 1, rNum);
        result.remove(result.size() - 1);
        result.add(rBrackets);
        back(n - 1, lNum, rNum + 1);
        result.remove(result.size() - 1);
    }

    private boolean valid(int lNum, int rNum) {
        if (rNum > lNum || lNum > num) {
            return false;
        }
        if (result.size() == 0) {
            return true;
        }
        return true;
    }
}
// @lc code=end

