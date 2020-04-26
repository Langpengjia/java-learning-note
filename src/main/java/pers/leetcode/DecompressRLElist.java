package pers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @classname: DecompressRLElist
 * @description: 官方给出的答案，侧重于贪心算法
 * @author: Desire
 * @date: 2020-01-17 16:02
 */
public class DecompressRLElist {

    public int[] cal(int[] nums) {
        String s = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        int[] in = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            in[i] = list.get(i);
        }
        return in;
    }


    public boolean robot(String command, int[][] obstacles, int x, int y) {
        List<int[]> collect = Arrays.stream(obstacles).filter(a -> (a[0] <= x && a[1] <= y)).collect(Collectors.toList());

        int startX = 0;
        int startY = 0;
        while (true) {
            char[] cs = command.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if('U' == cs[i])
                    startY += 1;
                else
                    startX += 1;

                for (int j = 0; j < collect.size(); j++) {
                    int[] obstacle = collect.get(j);
                    if (startY == obstacle[1] && startX == obstacle[0]) return false;
                }
                if (startX > x || startY > y) return false;
                if (startX == x && startY == y) return true;
            }
        }

    }

}
