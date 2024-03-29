package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest21 {

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表
    public static

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dump = new ListNode(-1);
            ListNode curr = dump;
            while (l1 != null || l2 != null) {
                if (l2 == null) {
                    curr.next = l1;
                    break;
                }
                if (l1 == null ) {
                    curr.next = l2;
                    break;
                }
                if (l1.val <= l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                    curr = curr.next;
                }else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                    curr = curr.next;
                }
            }
            return dump.next;
        }

        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            // maintain an unchanging reference to node ahead of the return node.
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }

            // exactly one of l1 and l2 can be non-null at this point, so connect
            // the non-null list to the end of the merged list.
            prev.next = l1 == null ? l2 : l1;

            return prehead.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(1);
            node1.addNext(2).addNext(4);

            ListNode node2 = new ListNode(1);
            node2.addNext(3).addNext(4);
            Assert.assertEquals("112344", solution.mergeTwoLists(node1, node2).getPositiveListNodeValue());
        }
    }
}