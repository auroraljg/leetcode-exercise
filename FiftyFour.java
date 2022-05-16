package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ljg
 * @ClassName: FiftyFour
 * @Description 54. 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @date : 2022/5/15 20:49
 */
public class FiftyFour {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> arr = new ArrayList<>();
            int top = 0, down = matrix.length-1;//行数
            int left = 0, right = matrix[0].length-1;//列数


            while (true) {
                for (int i = left; i <= right; ++i) {
                    arr.add(matrix[top][i]);
                }
                top++;
                if (top > down) break;
                for (int i = top; i <= down; ++i) {
                    arr.add(matrix[i][right]);
                }
                right--;
                if (left > right) break;
                for (int i = right; i >= left; --i) {
                    arr.add(matrix[down][i]);
                }
                down--;
                if (top > down) break;
                for (int i = down; i >= top; --i) {
                    arr.add(matrix[i][left]);
                }
                left++;
                if (left > right) break;

            }
            return arr;
        }
    }
}
