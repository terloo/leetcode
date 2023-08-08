/*
 * @lc app=leetcode.cn id=剑指 Offer 09 lang=java
 * @lcpr version=21908
 *
 * [剑指 Offer 09] 用两个栈实现队列
 *
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/description/
 *
 * LCOF
 * Easy (70.37%)
 * Likes:    743
 * Dislikes: 0
 * Total Accepted:    559.5K
 * Total Submissions: 795.1K
 * Testcase Example:  '["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]\n' +
  '[[],[3],[],[],[]]'
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 * 
 * 
 * 示例 2：
 * 
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class CQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.size() != 0) {
            return stack2.pop();
        }
        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }
        if (stack2.size() == 0) {
            return -1;
        }
        return stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
// @lc code=end

/*
// @lcpr case=start
// ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"][[],[3],[],[],[]]\n
// @lcpr case=end

// @lcpr case=start
// ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"][[],[],[5],[2],[],[]]\n
// @lcpr case=end

 */
