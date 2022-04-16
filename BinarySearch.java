package leetcode;

/**
 * @author : ljg
 * @ClassName: BinarySearch
 * @Description 704. 二分查找
 *          给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *          写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 *
 *          分析：前提是数组为有序数组且数组中无重复元素，导致元素下标唯一。
 *              考虑边界条件，对区间的定义没有想清楚，区间的定义就是不变量
 * @date : 2022/4/16 21:50
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        if (target < nums[low] || target > nums[high]) {
            return -1;
        }
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
