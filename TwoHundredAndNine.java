package leetcode;

/**
 * @author : ljg
 * @ClassName: TwoHundredAndNine
 * @Description 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 思路：
 * 暴力算法
 * 快慢指针变形，滑动窗口理论：就是不断的调节子序列的起始位置和终止位置
 * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
 * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。i++
 * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
 *
 * 最小滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最小长度。
 * while j < len(nums):
 *     判断[i, j]是否满足条件
 *     while 满足条件：
 *         不断更新结果(注意在while内更新！)
 *         i += 1 （最大程度的压缩i，使得滑窗尽可能的小）
 *     j += 1
 *

 * @date : 2022/5/2 21:48
 */
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right;
        int sum = 0;//表示窗口内序列的总和
        int result = Integer.MAX_VALUE;//当前环境表示的最大常量
        for (right = left; right < nums.length; right++) {
            sum += nums[right];
            //if改为while原因是必须保证在左指针左移一位的同时若sum总和还是大于目标值时，右指针不能移动，仍然进入该循环
            while (sum >= target) {
                //记录连续子数组的最小长度
                result = ((right - left + 1) < result) ? (right - left + 1) : result;
                sum -= nums[left];
                left++;//左指针左移一位
            }
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}

//class Solution1 {
//    public int minSubArrayLen(int target, int[] nums) {
//        int result = 99999999;//最大值
//        int sum = 0;
//        int length = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum >= target) {
//                    length = j - i + 1;
//                    result = (length < result) ? length : result;//更新结果
//                    break;
//                }
//            }
//        }
//        return (result == 99999999) ? 0 : result;
//    }
//}
public class TwoHundredAndNine {
}
