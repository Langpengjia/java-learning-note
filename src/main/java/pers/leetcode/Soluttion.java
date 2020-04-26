package pers.leetcode;

import java.util.*;

/**
 * @classname: Soluttion
 * @description:
 * @author: Desire
 * @date: 2020-01-19 14:25
 */
public class Soluttion {

    /**
     * 给你一个以行程长度编码压缩的整数列表 nums.
     * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
     * 请你返回解压后的列表。
     * <p>
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[2,4,4,4]
     * <p>
     * https://leetcode-cn.com/problems/decompress-run-length-encoded-list
     */
    public int[] decompressRLElist(int[] nums) {
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

    /**
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差.
     * 输入：n = 234
     * 输出：15
     * 解释：
     * 各位数之积 = 2 * 3 * 4 = 24
     * 各位数之和 = 2 + 3 + 4 = 9
     * 结果 = 24 - 9 = 15
     * <p>
     * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int res = 1;
        while (n > 0) {
            int s = n / 10;
            sum += s;
            res *= s;
            n /= 10;
        }
        return res - sum;
    }

    /**
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数.
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = 1;
            while (n > 0) {
                if (nums[i] / (10 * n) == 0) {
                    break;
                }
                n++;
            }
            if (n % 2 == 0) count += 1;
        }
        return count;
    }

    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jewels-and-stones
     */
    public int numJewelsInStones(String J, String S) {
        int n = 0;
        char[] js = J.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < js.length; i++) {
            list.add(js[i]);
        }
        char[] ss = S.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (list.contains(ss[i])) {
                n++;
            }
        }
        return n;
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            int[] before = points[i - 1];
            int[] now = points[i];
            int max = Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
            count += max;
        }
        return count;
    }

    public int getDecimalValue(ListNode head) {
        if (head.val == 0 && head.next == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head.val);
            head = head.next;
        }
        //多进一位
        stack.push(head.val);
        int count = 0;
        int n = 0;
        while (!stack.empty()) {
            count += stack.pop() * Math.pow(2, n);
            n++;
        }
        return count;
    }

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = map.get(A[i]);
        }
        return A;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int balancedStringSplit(String s) {
        if (s == null) {
            return 0;
        }
        //防止出现重复平衡的字符串的情况
        Set<Integer> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int countL = 0;
        int countR = 0;
        boolean isL = true;
        for (int i = 0; i < chars.length; i++) {
            isL = chars[i] == 'L' ? true : false;
            //测试Demo  RRRLLRLL  对读取RRRLLR时的特殊判断
            if ((countR != 0 && countR < countL && isL) || (countL != 0 && countL < countR && !isL)) {
                set.add(countR < countL ? countR : countL);
                countL = 0;
                countR = 0;
            }
            if (chars[i] == 'L')
                countL++;
            else
                countR++;

            if (countL != 0 && countL == countR) {
                set.add(countL);
                countL = 0;
                countR = 0;
            }
        }
        return set.size();
    }

    public String removeOuterParentheses(String S) {
//        Stack<String> stack = new Stack<>();
//        String s = "";
//        //有效括号字符串，不考虑非法情况
//        char[] chars = S.toCharArray();
//        StringBuffer stringBuffer = new StringBuffer("");
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '(')
//                stack.push("s");
//            else
//                stack.pop();
//            //完成一次
//            if (stack.isEmpty()) {
//                stringBuffer.append(s.substring(1));
//                s = "";
//                continue;
//            }
//            s += chars[i];
//        }
//        return stringBuffer.toString();

        //下面，来膜拜大神写法！！！！！
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }
        return sb.toString();
    }


    public int sumOfDigits(int[] A) {
        Arrays.sort(A);
        int min = A[0];
        int sum = 0;
        String[] split = String.valueOf(min).split("");
        for (String s : split) {
            sum += Integer.valueOf(s);
        }
        return sum % 2 == 0 ? 1 : 0;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            int temp = left;
            boolean b = true;
            while(temp>0){
                int rex = temp%10;
                //不允许包括0
                if(rex == 0 || temp%rex!=0){
                    b = false;
                    break;
                }
                temp /= 10;
            }
            if(b){
                list.add(left);
            }
        }
        return list;
    }


    public int[] sumZero(int n) {

        Set<Integer> set = new HashSet<>();
        int length = n/2;
        int[] array = new int[n];
        int i = 0;
        if(n%2==1){
            i = 1;

        }

        for (; i < n; i++) {

        }
        return array;
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int min = 0;
        for(int i = 1;i<arr.length;i++){
            if(min!=0){
                if(min > (arr[i]-arr[i-1])){
                    list.clear();
                    list.add(Arrays.asList(arr[i-1],arr[i]));
                    min = arr[i]-arr[i-1];
                }else if(min == (arr[i]-arr[i-1])){
                    list.add(Arrays.asList(arr[i-1],arr[i]));
                }
            }else {
                list.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(5/2);
    }
}
