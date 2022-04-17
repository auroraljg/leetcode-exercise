package leetcode;

/**
 * @author : ljg
 * @ClassName: ThirtyFour
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 思路：首先考虑目标值出现的情况：
 *                      1.目标值在于小于数组最左侧或大于最右侧，返回[-1, -1]
 *                      2.目标值在数组数值范围之内，但不存在目标值，则返回[-1, -1]
 *                      3.目标值命中，返回正常边界值[左边界, 右边界]
 *       因此应该采取分别探寻目标值的左边界或右边界的方法，根据返回值确定属于什么情况
 * @date : 2022/4/17 21:38
 */
public class ThirtyFour {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder =  leftEdge(nums, target);
        int rightBorder = rightEdge(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        // 情况三
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    //寻找目标值的左边界点下标
    public int leftEdge(int[] nums,int target){
        int left = -2;  //显示初始化为本不该出现的下标
        int low = 0,high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(target > nums[mid]){
                low = mid + 1;
            }else{      //相等时，应更新右边界点high
                high = mid - 1;
                left = high;
            }
        }
        return left;
    }
    //寻找目标值的右边界点下标
    public int rightEdge(int[] nums,int target){
        int right = -2;  //显示初始化为本不该出现的下标
        int low = 0,high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(target < nums[mid]){
                high = mid - 1;
            }else{       //相等时，应更新左边界low
                low = mid + 1;
                right = low;
            }
        }
        return right;
    }
}
