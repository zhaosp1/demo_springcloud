package com.example.utilservice.battle.common.test;

/**
 * @description: 练习（how2j）
 * @function：
 * @author: zhaosp1
 * @date: 2021/8/22 11:34
 **/
public class Solution01 {

  static class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static void print(ListNode l) {
    ListNode t = l;
    while (t != null) {
      System.out.println(t.val);
      t = t.next;
    }
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(5);
    ListNode t = listNode;
    t.next = new ListNode(0);
    t = t.next;
    t.next = new ListNode(5);
    print(listNode);

    ListNode listNode1 = new ListNode(5);
    ListNode t1 = listNode1;
    t1.next = new ListNode(0);
    t1 = t1.next;
    t1.next = new ListNode(5);
    print(listNode1);

    ListNode t3 = addTwoNumbers(listNode, listNode1);
    print(t3);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l3=new ListNode(-1);
    ListNode temp=l3;
    int index=0;
    while (l1!=null||l2!=null||index!=0){
      int var1=l1==null?0:l1.val;
      int var2=l2==null?0:l1.val;

      int sum=var1+var2+index;
      index=sum/10;
      int value=sum%10;

      temp.next=new ListNode(value);
      temp=temp.next;

      if(l1!=null)l1=l1.next;
      if(l2!=null)l2=l2.next;
    }
    return l3;
  }
}
