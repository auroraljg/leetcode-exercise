package leetcode;

/**
 * @author : ljg
 * @ClassName: NineHundredAndFour
 * @Description 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 思路：最大滑窗模板：给定数组 nums，定义滑窗的左右边界 i, j，求满足某个条件的滑窗的最大长度。
 * while j < len(nums):
 * 判断[i, j]是否满足条件
 * while 不满足条件：
 * i += 1 （最保守的压缩i，一旦满足条件了就退出压缩i的过程，使得滑窗尽可能的大）
 * 不断更新结果（注意在while外更新！）
 * j += 1
 * @date : 2022/5/3 22:04
 */
public class NineHundredAndFour {
    public int totalFruit(int[] fruits) {
        int[] arr = new int[fruits.length];//代表所有水果种类的数组
        int i = 0, j = 0;
        int result = -1;
        int count = 0; //计算当前已有的水果种类
        while (j < fruits.length) {
            //新增加了一种水果，判断当前是否满足条件
            if (arr[fruits[j]] == 0) {
                count++;
            }
            arr[fruits[j]]++;
            //不满足条件
            while (count > 2) {
                //即将退出的水果元素数量只有1的情况下
                if (arr[fruits[i]] == 1) {
                    count--;
                }
                arr[fruits[i]]--;
                i++;
            }
            //不断更新结果
            result = Math.max(result, (j - i + 1));
            j++;
        }
        return result;
    }
}
