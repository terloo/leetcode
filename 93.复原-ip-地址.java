import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (54.07%)
 * Likes:    720
 * Dislikes: 0
 * Total Accepted:    160.8K
 * Total Submissions: 296.5K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按 任何 顺序返回答案。
 * 
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return res;
    }

    int isValidIp(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return 0;
        }
        if (s.length() > 3) {
            return 0;
        }
        if (Integer.parseInt(s) > 255) {
            return 0;
        }
        return 1;
    }

    void backtracking(String s, int splitIndex, int level) {
        if (level == 4 && splitIndex == s.length()) {
            res.add(String.join(".", path));
        }
        if ((4 - level) * 3 < (s.length() - splitIndex)) {
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            String ip = s.substring(splitIndex, i + 1);
            if (isValidIp(ip) == 0) {
                return;
            }
            path.add(ip);
            backtracking(s, i + 1, level + 1);
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end
