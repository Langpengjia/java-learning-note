package pers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @classname: FourSum
 * @description: 四数求和 可以理解为三数求和的升级版，活用 游标理论 可以很快解决
 * @author: Desire
 * @date: 2020-01-16 9:56
 */
public class FourSum {


    public static void main(String[] args) {

        //[5,5,3,5,1,-5,1,-2]
        int[] ss = new int[]{5, 5, 3, 5, 1, -5, 1, -2};
        Arrays.sort(ss);
        Arrays.stream(ss).forEach(System.out::print);
        System.out.println(ss);
        FourSum threeSum = new FourSum();
        List<List<Integer>> lists = threeSum.fourSum(ss, 4);
        lists.forEach(System.out::println);

    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //参考三数之和 将 i j 当做一个数
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        int length = nums.length;
        //排除所有不可能的情况
        if (length < 4
                || (nums[0] + nums[1] + nums[2] + nums[3] > target)
                || (nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4] < target)) {
            return result;
        }
        for (int i = 0; i < length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            while (j < length - 2) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int L = j + 1;
                int R = length - 1;
                while (L < R) {
                    //排除遍历中L重复的情况
                    if (L != j + 1 && nums[L] == nums[L - 1]) {
                        L++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum < target) {
                        L++;
                        continue;
                    } else if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                    }
                    while(R>L){
                        if(nums[R] == nums[R - 1]){
                            R--;
                            continue;
                        }else {
                            R--;
                            break;
                        }
                    }

                    continue;
                }
                j++;
            }
        }
        return result;
    }


}


