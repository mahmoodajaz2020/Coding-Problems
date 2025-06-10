package util.leetcode.Num92ReverseLinkedListII;

import util.objects.ListNode;

public class RevLinkList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int size=getSize(head);
        if(left==1 && right==size){
            return  revList(null, head);
        }
        ListNode leftConnector=head;
        ListNode rightConnector=head;
        ListNode begin=head;
        ListNode end=head;
        int i=1;
        while(i<left-1){
            leftConnector=leftConnector.next;
            begin=begin.next;
            i++;
        }
        begin=begin.next;
        i=1;
        while(i<right){
            rightConnector=rightConnector.next;
            end=end.next;
            i++;
        }
        rightConnector=rightConnector.next;
        end.next=null;
        ListNode reversed=revList(null, begin);
        leftConnector.next=reversed;
        while(reversed.next!=null){
            reversed=reversed.next;
        }
        reversed.next=rightConnector;
        System.out.println(" Lef C:"+ leftConnector.val);
        System.out.println(" beg:"+ begin.val);
        System.out.println(" Right C:"+ rightConnector.val);
        System.out.println(" end:"+ end.val);
        return head;
    }
    public ListNode revList(ListNode prev, ListNode next){
        if(next.next==null){
            next.next=prev;
            return next;
        }
        ListNode nextNode=next.next;
        next.next=prev;
        return revList(next, nextNode);
    }
    public int getSize(ListNode head){
        ListNode ref=head;
        int size=0;
        while(ref!=null){
            size++;
        }
        return size;
    }
}