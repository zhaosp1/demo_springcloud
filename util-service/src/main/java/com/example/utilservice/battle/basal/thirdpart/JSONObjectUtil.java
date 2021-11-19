package com.example.utilservice.battle.basal.thirdpart;

import com.example.battle.common.pojo.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class JSONObjectUtil {
  //JSONObject的遍历
  public void test() {
    JSONObject json = new JSONObject();
    json.element("1", new int[] { 1, 2, 3 }).element("2", (new JSONArray()).element(1).element(2));
    json.element("3", 5.6);
    json.element("4", "abc");
    for (Object str : json.keySet()) {
      String key = (String) str;
      System.out.println(json.get(key));
    }

    Set<Object> ss = json.entrySet();
    for (Object o : ss) {
      System.out.println(o);
    }
    Collection<Object> col = json.values();
    System.out.println(col);
    Iterator<Object> it = col.iterator();
    while (it.hasNext()) {
      //取出迭代器对应的值
      System.out.println(it.next());
    }
  }

  public static void main(String[] args) {
    JSONObject jsonObject = JSONObject.fromObject(new User(1, "tom", "man"));
    System.out.println(jsonObject);
  }
}
