package pers.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @classname: LengthOfLongestSubstring
 * @description:
 * @author: Desire
 * @date: 2020-01-17 13:14
 */
public class LengthOfLongestSubstring {

    public int cal(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        List<String> list = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        String temp = "";

        for (int i = 0; i < length; i++) {
            if (!charSet.contains(chars[i])) {
                temp += chars[i];
                list.add(temp);
                charSet.add(chars[i]);
            } else {
                temp = "";
                charSet.clear();
                charSet.add(chars[i]);
                temp += chars[i];
            }
        }
        return Collections.max(list.stream().map(String::length).collect(Collectors.toList()));
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null ||root.val == target){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left!=null){
            if(left==null||left.val == target){
                left = null;
                break;
            }else {
                left = left.left;
            }

        }
        while (right!=null){
            if(right==null||right.val == target){
                right = null;
                break;
            }else {
                right = right.right;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring c = new LengthOfLongestSubstring();
        System.out.println(c.cal("dvdf"));

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
