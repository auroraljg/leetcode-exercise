package leetcode;

/**
 * @author : ljg
 * @ClassName: TwentySeven
 * @Description 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 *     int len = removeElement(nums, val);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 思路：
 *      1.数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
 *      2.双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
 * @date : 2022/4/18 21:40
 */
public class TwentySeven {
//    public int removeElement(int[] nums, int val) {
//        int len = nums.length;
//        //表示跳跃赋值的间距，即该坐标前与val相等的元素的数量
//        int k = 0;   //k起到快慢指针
//        for (int i = 0;i < nums.length;i++) {
//            if(nums[i] == val) {
//                k++;
//                len--;
//            }else {
//                nums[i - k] = nums[i];  //重新赋值替换元素
//            }
//        }
//        return len;
//    }
    public int removeElement(int[] nums, int val) {

        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
