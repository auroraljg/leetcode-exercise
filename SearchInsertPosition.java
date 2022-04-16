package leetcode;

/**
 * @author : ljg
 * @ClassName: SearchInsertPosition
 * @Description 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 分析：考察对边界条件的分析
 * @date : 2022/4/16 21:54
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle;
        if (target < nums[left]) {
            return left;
        }
        if (target > nums[right]) {
            return right + 1;
        }
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (target == nums[middle]) {
                return middle;
            }else if(target > nums[middle]) {
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }
}
