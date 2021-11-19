package com.example.utilservice.battle.common.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * TODO
 * 散列列表——自定义散列列表（使用应用结构定义的链表）
 *
 * @author zhaosp1
 * @version 1.0
 * @date 2021/8/15 10:38
 */
public class LinkedStruct {
  Node first;
  Node last;
  int size=0;

  private static class Node {
    Object object;
    Node next;
    Node prev;


    public Node(Node prev,Object object,Node next) {
      this.prev=prev;
      this.object=object;
      this.next=next;
    }
  }

  /**
   * 链表添加元素
   * @param object
   */
  public void add(Object object){
    Node l=last;
    Node newNode=new Node(l,object,null);
    last=newNode;
    if(l==null){
      first=newNode;
    }else {
      l.next=newNode;
    }
    size++;
  }

  public void remove(int index){
    Node node=getNode(index);
    Node prev=node.prev;
    Node next=node.next;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      node.prev = null;
    }

    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      node.next = null;
    }
    node.object=null;
    size--;
  }

  /**
   * 查询链表元素
   * @param index
   * @return
   */
  public Object get(int index){
    return getNode(index).object;
  }

  /**
   * 查询链表结点
   * @param index
   * @return
   */
  public Node getNode(int index){
    if(index<(size>>1)){
      Node x = first;
      for (int i = 0; i < index; i++)
        x = x.next;
      return x;
    } else {
      Node x = last;
      for (int i = size - 1; i > index; i--)
        x = x.prev;
      return x;
    }
  }

  /**
   * 获取链表的长度
   * @return
   */
  public int size(){
    return this.size;
  }

  public static void main(String[] args) {
    LinkedStruct ls=new LinkedStruct();
    ls.add("hello");
    ls.add("world");
    ls.remove(0);
    System.out.println(String.valueOf(ls.get(0)));
    
  }
}
