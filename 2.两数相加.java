/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (40.91%)
 * Likes:    6925
 * Dislikes: 0
 * Total Accepted:    1M
 * Total Submissions: 2.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        int i1 = 0;
        int i2 = 0;
        boolean carry = false;
        int sum = 0;
        while (l1 != null && l2 != null) {
            i1 = l1.val;
            i2 = l2.val;

            if (carry) {
                sum = i1 + i2 + 1;
            } else {
                sum = i1 + i2;
            }
            carry = sum >= 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            sum = 0;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 处理剩余节点
        ListNode tmp2 = l1 == null ? l2 : l1;
        while (carry && tmp2 != null) {
            tmp2.val++;
            if (tmp2.val >= 10 && tmp2 != null) {
                tmp.next = new ListNode(sum % 10);
                tmp = tmp.next;
                carry = true;
                tmp2 = tmp2.next;
                continue;
            }
            carry = false;
        }
        if (carry) {
            tmp.next = new ListNode(1);
        } else {
            tmp.next = tmp2;
        }
        return head.next;
    }
}
// @lc code=end
