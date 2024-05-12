package org.romin;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */


public class LeetCode13 {


    /**
     *
     *初始状态：
     *
     * 第8個
     * X  num = 10 ans = 0
     * 40 < 0
     * 不成立 : 加法
     * 10 + 0  = (ans) 10
     * 第7個
     * I  num = 1 ans = 10
     * 4 < 10
     * 成立 : 減法
     * 1 - 10 = (ans) 9
     * 第6個
     * C  num = 100 ans = 9
     * 400 < 9
     * 不成立 : 加法
     * 100 + 9  = (ans) 109
     * 第5個
     * X  num = 10 ans = 109
     * 40 < 109
     * 成立 : 減法
     * 10 - 109 = (ans) 99
     * 第4個
     * M  num = 1000 ans = 99
     * 4000 < 99
     * 不成立 : 加法
     * 1000 + 99  = (ans) 1099
     * 第3個
     * C  num = 100 ans = 1099
     * 400 < 1099
     * 成立 : 減法
     * 100 - 1099 = (ans) 999
     * 第2個
     * M  num = 1000 ans = 999
     * 4000 < 999
     * 不成立 : 加法
     * 1000 + 999  = (ans) 1999
     * 第1個
     * M  num = 1000 ans = 1999
     * 4000 < 1999
     * 不成立 : 加法
     * 1000 + 1999  = (ans) 2999
     * 第0個
     * M  num = 1000 ans = 2999
     * 4000 < 2999
     * 不成立 : 加法
     * 1000 + 2999  = (ans) 3999
     * 3999
     *
     */
    @Test
    public void test() {
        /**
         * M = 1000
         * M = 1000
         * M = 1000
         * C = 100
         * M = 1000
         * X = 10
         * C = 100
         * I = 1
         * X = 10
         */
        String x = "MMMCMXCIX";
        System.out.println(romanToInt("VIII"));
    }

    public int romanToInt2(String s) {
        //定義規則
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String v1 = s.substring(i, i + 1); //取得第一個數
            //取得第二個數 , 如果是最後一個數字就不取
            String v2 = i < s.length() - 1 ? s.substring(i, i + 2) : null;
            //先判斷兩個字串規則是否成立, 若不成立, 採用一個字串規則
            if (v2 != null && map.containsKey(v2)) {
                result += map.get(v2);
                i++;
            } else {
                result += map.get(v1);
            }
        }
        return result;
    }

    /**
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int ans = 0, num = 0;
        //從後往前迭代 , 大的在前面, 小的在後面
        for (int i = s.length() - 1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            /**
             * 重點規則
             * I可以放在V(5)和X(10)之前，得到4和9。
             * X可以放在L(50) 和C(100) 之前，得到 40 和 90。
             * C可以放在D(500) 和M(1000) 之前，得到 400 和 900。
             * 保證 是範圍s內的有效羅馬 數字[1, 3999]。
             * 主要後面開始跟前面比較, 因為左邊一定比較大, 所以會加法,
             * 檢查目前值 (num) 是否小於累計值 (ans)
             * 的 1/4。如果是，則從 ans 中減去目前值，
             * 因為它表示羅馬格式的減法（例如，「IV」表示 4，其中 5 減去 1）。
             * 從最後一個數字開始。因此，在獲得 V 之前，您最多會得到 3 次 I。
             */
            if ( num * 4  < ans) ans -= num;
            else ans += num;
        }
        return ans;

    }

}
