package com.example.utilservice.battle.common.constant;

import java.util.*;

public class Temp {
  public static Map getMap(){
    Map map=new HashMap();
    map.put("1","1");
    map.put("2","2");
    map.put("3","3");
    map.put("4","4");
    map.put("5","5");
    return map;
  }

  public static List getList(){
    List list=new ArrayList();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("1");
    list.add("5");
    list.add("4");
    list.add("6");
    return list;
  }

  public static Set getSet(){
    Set set=new HashSet();
    set.add("1");
    set.add("2");
    set.add("3");
    set.add("1");
    set.add("5");
    set.add("4");
    set.add("6");
    return set;
  }
}
