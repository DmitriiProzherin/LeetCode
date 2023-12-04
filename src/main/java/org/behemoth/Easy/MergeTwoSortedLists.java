package org.behemoth.Easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        ListNode list1 = head1.next;
        list1.next = new ListNode(3);

//        while (head1 != null) {
//            System.out.print(head1.val + " ");
//            head1 = head1.next;
//        }

        System.out.println();

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode list2 = head2.next;
        list2.next = new ListNode(4);

//        while (head2 != null) {
//            System.out.print(head2.val + " ");
//            head2 = head2.next;
//        }
        ListNode head3 = Solution.mergeTwoLists(new ListNode(), head2.next);

        while (head3 != null){
            System.out.println(head3.val);
            head3 = head3.next;
        };
    }

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode list3 = new ListNode();
            ListNode head = list3;
            while (true){
                if (list1.next != null) {
                    if (list2.next != null) {
                        System.out.println();
                    }
                    else {
                        list3.next = list1.next;
                        return head;
                    }
                }
                else {
                    if (list2.next == null) {
                        return head;
                    }
                    else {
                        list3.next = list2.next;
                        return head;
                    }
                }
            }
        }
    }
}
