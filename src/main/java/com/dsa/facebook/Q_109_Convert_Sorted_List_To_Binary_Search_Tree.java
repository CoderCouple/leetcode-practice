package com.dsa.facebook;

public class Q_109_Convert_Sorted_List_To_Binary_Search_Tree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        ListNode mid = getMidPointNode(head);
        TreeNode root = new TreeNode(mid.val);
        if(mid == head)
            return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    public ListNode getMidPointNode(ListNode head){
        if(head == null)
            return head;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null)
            prev.next = null;

        return slow;
    }

    public static void main(String[] args) {

    }
}

