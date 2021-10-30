import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (41.76%)
 * Likes:    646
 * Dislikes: 0
 * Total Accepted:    202.8K
 * Total Submissions: 485.5K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 
 * 0 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        List<ListNode> nodelist = new ArrayList<>();
        while (head != null) {
            nodelist.add(head);
            head = head.next;
        }

        int len = nodelist.size();
        if (len == 1) {
            return nodelist.get(0);
        }
        nodelist.get(len - 1).next = nodelist.get(0);

        k %= len;
        nodelist.get(len - k - 1).next = null;
        if (k == 0) {
            return nodelist.get(0);
        }
        return nodelist.get(len - k);
    }
}
// @lc code=end
