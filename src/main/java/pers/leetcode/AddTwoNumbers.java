package pers.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Desire
 * @date: 2020-01-17 9:48
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        //此处两个if判断为下方while循环做准备，防止空指针，同时简化逻辑
        if (l1 == null) {
            l1 = new ListNode(0);
            return l2;
        }

        if (l2 == null) {
            l2 = new ListNode(0);
            return l1;
        }
        //root 指向 l1
        ListNode root = new ListNode(0);
        root.next = l1;
        //将所有情况相加，此时root是最终版本
        while (l1.next != null && l2.next != null) {
            l1.val += l2.val;
            l1 = l1.next==null?new ListNode(0):l1;
            l2 = l2.next==null?new ListNode(0):l2;
        }
        ListNode temp = root;
        //操作temp


        return root;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
