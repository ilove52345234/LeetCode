package org.romin;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode14 {

    @Test
    public void test() {
        String[] strs = {"a", "flower", "flxx", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }


    /**
     * 當進行自然排序時,會根據ASCII值進行排序,找到每個字不同後按照大小排列
     * 排序後中間的字串如果有相同公共前綴就放在一起
     * 而第一個宇最後一個會有最大的差異性,所以只要比較這兩個字串就可以找到最大公共前綴
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); //對進行排序, 排序後我們只要比較第一個最後一個
        String s1 = strs[0]; //取第一個
        String s2 = strs[strs.length - 1]; //取最後一個
        int index = 0;
        while (index < s1.length() && index < s2.length()) {//確保兩個字串長度都能循環到
            //如果兩個字串相同, index+1, 直到不同為止跳出迴圈
            if (s1.charAt(index) == s2.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return s1.substring(0, index);//根據index取得最大相同字
    }
}
