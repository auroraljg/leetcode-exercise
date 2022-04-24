package leetcode;

import java.sql.SQLOutput;

/**
 * @author : ljg
 * @ClassName: NineHundredAndSeventySeven
 * @Description 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 思路：由于该数组是带负数的非递减顺序排列，其元素的平方最大值只可能在两边，
 *      则可设置双指针从原数组两端开始遍寻，每次得到平方较大值加入新数组
 * @date : 2022/4/24 21:44
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        //新建一个同等大小的新数组
        int k = nums.length;
        int[] newNums = new int[k];
        int i = 0, j = k - 1;
        //每次将两端元素平方值较大的数加入新数组
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                newNums[--k] = nums[j] * nums[j];
                j--;
            } else {
                newNums[--k] = nums[i] * nums[i];
                i++;
            }
        }

        return newNums;
    }
}

public class NineHundredAndSeventySeven {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums;
        nums = new int[]{-7, -3, 2, 3, 11};
        int[] newNums = s.sortedSquares(nums);
        for (int i = 0; i < newNums.length; i++) {
            System.out.println(newNums[i]);
        }
    }
}
