package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

class SolutionTest23 {
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2403 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> treeSet = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode list : lists) {
                if (list != null) {
                    treeSet.add(list);
                }
            }
            ListNode head = new ListNode(-1);
            ListNode curr = head;
            while (!treeSet.isEmpty()) {
                ListNode node = treeSet.poll();
                curr.next = new ListNode(node.val);
                curr = curr.next;
                if (node.next != null) {
                    treeSet.add(node.next);
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 1, 2, 3, 4, 4, 5, 6]", solution.mergeKLists(new ListNode[]{ListNode.fromArray(new Integer[]{1, 4, 5}), ListNode.fromArray(new Integer[]{1, 3, 4}), ListNode.fromArray(new Integer[]{2, 6})}).toArrayString());
        }

    }
}