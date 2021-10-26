import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (57.30%)
 * Likes:    1571
 * Dislikes: 0
 * Total Accepted:    352.3K
 * Total Submissions: 614.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */

// @lc code=start
class Solution {

    private Map<Character, List<String>> map = new HashMap<>();

    private List<String> result = new LinkedList<>();

    {
        map.put('2', Arrays.asList(new String[] { "a", "b", "c" }));
        map.put('3', Arrays.asList(new String[] { "d", "e", "f" }));
        map.put('4', Arrays.asList(new String[] { "g", "h", "i" }));
        map.put('5', Arrays.asList(new String[] { "j", "k", "l" }));
        map.put('6', Arrays.asList(new String[] { "m", "n", "o" }));
        map.put('7', Arrays.asList(new String[] { "p", "q", "r", "s" }));
        map.put('8', Arrays.asList(new String[] { "t", "u", "v" }));
        map.put('9', Arrays.asList(new String[] { "w", "x", "y", "z" }));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        lookup("", digits);
        return result;
    }

    private void lookup(String prefix, String digits) {
        if ("".equals(digits)) {
            result.add(prefix);
            return;
        }
        for (String str : map.get(digits.charAt(0))) {
            lookup(prefix + str, digits.substring(1));
        }
    }
}
// @lc code=end
