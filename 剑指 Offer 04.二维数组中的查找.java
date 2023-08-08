/*
 * @lc app=leetcode.cn id=剑指 Offer 04 lang=java
 * @lcpr version=21913
 *
 * [剑指 Offer 04] 二维数组中的查找
 *
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/description/
 *
 * LCOF
 * Medium (39.56%)
 * Likes:    945
 * Dislikes: 0
 * Total Accepted:    507.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减
 * 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 
 * 
 * 示例:
 * 
 * 现有矩阵 matrix 如下：
 * 
 * [
 * ⁠ [1,   4,  7, 11, 15],
 * ⁠ [2,   5,  8, 12, 19],
 * ⁠ [3,   6,  9, 16, 22],
 * ⁠ [10, 13, 14, 17, 24],
 * ⁠ [18, 21, 23, 26, 30]
 * ]
 * 
 * 
 * 给定 target = 5，返回 true。
 * 
 * 给定 target = 20，返回 false。
 * 
 * 
 * 
 * 限制：
 * 
 * 0 <= n <= 1000
 * 
 * 0 <= m <= 1000
 * 
 * 
 * 
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 
 */

// @lc code=start
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }

        int binSearchResult = matrix[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            binSearchResult = binSearch(matrix[i], target, 0, binSearchResult);
            if (binSearchResult == -1) {
                return true;
            }
        }
        return false;

    }

    private int binSearch(int[] arr, int target, int begin, int end) {
        if (begin == end) {
            if (arr[begin] == target) {
                return -1;
            } else {
                return begin;
            }
        }

        int left = begin;
        int right = end;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                return -1;
            }

            if (left == right) {
                return left;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end
