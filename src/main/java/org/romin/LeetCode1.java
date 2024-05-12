package org.romin;
/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * Only one valid answer exists.
 * <p>
 * <p>
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than
 * O(n²)
 * time complexity?
 * <p>
 * Related Topics Array Hash Table 👍 56055 👎 1931
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 * <p>
 * leetcode submit region end(Prohibit modification and deletion)
 */


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    int[] nums = {2, 7, 11, 15};

    @Test
    public void test() {
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
    public int[] twoSum (int[] nums, int target) {
        //hashMap有快速查詢的特性
        Map<Integer, Integer> map = new HashMap<>();
        // 目標從第一個數開始相減, 差值在表找, 有的話返回兩個的index
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i); //沒有的話放入表
        }
        return new int[]{}; //沒有找到 返回空字串
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }



}
