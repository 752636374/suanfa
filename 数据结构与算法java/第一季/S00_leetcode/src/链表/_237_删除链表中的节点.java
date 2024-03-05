package 数据结构与算法java.第一季.S00_leetcode.src.链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author MJ Lee
 *
 */
public class _237_删除链表中的节点 {
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
    }
}
