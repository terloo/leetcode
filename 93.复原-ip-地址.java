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

    // 判断分割出来的每一段字符串是否是合法的IP地址
    boolean isValidIp(String s) {
        //判断其是否含有前导0
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        //长度为4就直接舍弃，加上这一步是为了后面parseInt做准备,防止超过了Integer可以表示的整数范围
        if (s.length() > 3) {
            return false;
        }
        //将字符转为int判断是否大于255，因为题目明确说了只由数字组成，所以这里没有对非数字的字符进行判断
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    void backtracking(String s, int splitIndex, int level) {
        //递归终止条件，分割的四个字符串都是合法的IP地址
        if (level == 4) {
            //在代码的最后再利用join函数加上“.”,构造IP地址的表示形式
            res.add(String.join(".", path));
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            //每一次分割之后，对剩余字符长度是否合理进行判断，剪枝操作，优化运行速度
            if ((s.length() - i - 1) > 3 * (3 - level)) {
                continue;
            }
            //如果分割的字符串不是合理的IP地址，跳过
            if (!isValidIp(s.substring(splitIndex, i + 1))) {
                continue;
            }
            //把合法的IP地址段加入path存储
            path.add(s.substring(splitIndex, i + 1));
            //每次把分割线往后移一位，且段数level+1
            backtracking(s, i + 1, level + 1);
            //进行回溯操作
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end
