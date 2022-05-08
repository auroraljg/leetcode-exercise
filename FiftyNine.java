package leetcode;

/**
 * @author : ljg
 * @ClassName: FiftyNine
 * @Description 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 思路：首先新建一个n*n的数组并全部初始化为0.然后逐一按照向右向下向左向上循环顺序赋值，
 * 其中赋值时要验证此处尚未赋值，直到全部坐标都重新赋值
 * @date : 2022/5/8 21:39
 */
public class FiftyNine {
    public int[][] generateMatrix(int n) {
        //新建并初始化数组arr
        int[][] arr = new int[n][n];
        int operate = 0;//表示操作顺序
        int num = 1;//表式赋值的数
        int i = 0, j = -1;
        while (num <= n * n) {
            switch (operate % 4) {
                //向右
                case 0:
                    j++;
                    while (j < n && arr[i][j] == 0) {
                        arr[i][j++] = num;
                        num++;
                    }
                    j--;
                    break;
                //向下
                case 1:
                    i++;//到达下一个坐标
                    while (i < n && arr[i][j] == 0) {
                        arr[i++][j] = num;
                        num++;
                    }
                    i--;
                    break;
                //向左
                case 2:
                    j--;
                    while (j >= 0 && arr[i][j] == 0) {
                        arr[i][j--] = num;
                        num++;
                    }
                    j++;
                    break;
                //向上
                case 3:
                    i--;
                    while (i >= 0 && arr[i][j] == 0) {
                        arr[i--][j] = num;
                        num++;
                    }
                    i++;
                    break;
            }
            operate++;
        }
        return arr;
    }

    public static void main(String[] args) {
        FiftyNine test = new FiftyNine();
        int n = 6;
        int[][] arr = test.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
