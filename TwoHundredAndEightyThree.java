package leetcode;

/**
 * @author : ljg
 * @ClassName: TwoHundredAndEightyThree
 * @Description 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 * 思路：覆盖法：在快慢指针消除所有元素的同时，将补足后续元素为0(其中元素数目为快慢指针下标之差)
 *       交换法：快指针每次遇到非零元素，就和慢指针交换一次，并且慢指针右移一位
 * @date : 2022/4/19 21:15
 */
public class TwoHundredAndEightyThree {
    public void moveZeroes(int[] nums) {
        //覆盖法
//        //快慢双指针
//        int fastIndex = 0;
//        int slowIndex;
//        for (slowIndex = 0;slowIndex < nums.length;fastIndex++) {
//            if (fastIndex < nums.length) {
//                if (nums[fastIndex] != 0) {
//                    nums[slowIndex] = nums[fastIndex];
//                    slowIndex++;
//                }
//            }else {         //数组所有非零元素已去除，后面位置补充0
//                nums[slowIndex] = 0;
//                slowIndex++;
//            }
//        }
        //交换法
        int  slowIndex = 0, fastIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != 0) {
                swap(nums, slowIndex, fastIndex);
                slowIndex++;
            }
            fastIndex++;
        }
    }
    //交换数组两元素
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
