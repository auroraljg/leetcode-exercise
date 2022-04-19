package leetcode;

/**
 * @author : ljg
 * @ClassName: EightHundredAndFortyFour
 * @Description 844. 比较含退格的字符串
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 思路：此题采用双指针法应从后往前移动，原因是#键只对其左边元素有影响
 * @date : 2022/4/19 21:39
 */
public class EightHundredAndFortyFour {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int iSkip,jSkip; //表示此处应回退几格
        for (iSkip = 0,jSkip = 0;i >= 0 || j >= 0;i--,j--) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {   //当遇到#键时，应该回退一格，iSkip+1
                    iSkip++;
                    i--;
                } else if (iSkip > 0) {    //非#键时，应检查iSkip是否不为0，是的话iSkip-1且回退一格
                    iSkip--;
                    i--;
                } else {          //非#键且iSkip为0，则表示找到该比较的元素下标
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    jSkip++;
                    j--;
                } else if (jSkip > 0) {
                    jSkip--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {  //两个坐标都没到-1
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {                //至少有一个坐标到-1
                if (i >= 0 || j >= 0) {     //只有一个坐标到-1
                    return false;
                }
            }
        }
        return true;
    }
}
