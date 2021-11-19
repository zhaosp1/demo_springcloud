package com.example.utilservice.battle.basal.util;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：redis工具类
 * @date 2021/8/19 0:07
 */
public class RedisUtil {
  public static Jedis getJedis() {
    return new Jedis("localhost");
  }

  public static Jedis getJedis(String host, int port) {
    return new Jedis(host, port);
  }

  //String类型操作
  public static void doString() {
    try (Jedis jedis = getJedis()) {
      //单值设定
      jedis.set("s", "hello");
      jedis.append("s", " world!");
      System.out.println(jedis.get("s"));
      jedis.mset("ms1", "hao", "ms2", "buhao");

      //多值设定
      List<String> list = jedis.mget("ms1", "ms2");
      list.forEach(e -> System.out.print(e + "\t"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //hashmap类型操作
  public static void doMap() {
    try (Jedis jedis = getJedis()) {
      Map<String, String> user = new HashMap<>();
      user.put("id", "123");
      user.put("name", "tom");
      user.put("age", "23");

      jedis.hmset("map", user);
      jedis.hdel("map", "age");
      System.out.println(jedis.hmget("map", "age"));
      System.out.println(jedis.hlen("map")); //返回key为map的键中存放的值的个数1
      System.out.println(jedis.exists("map"));//是否存在key为map的记录 返回true
      System.out.println(jedis.hkeys("map"));//返回map对象中的所有key
      System.out.println(jedis.hvals("map"));//返回map对象中的所有value

      Iterator<String> iter = jedis.hkeys("map").iterator();
      while (iter.hasNext()) {
        String key = iter.next();
        System.out.println(key + ":" + jedis.hmget("map", key));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //list类型操作
  public static void doList() {
    try (Jedis jedis = getJedis()) {
      //开始前，先移除所有的内容
      jedis.del("java framework");
      // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
      System.out.println(jedis.lrange("java framework", 0, -1));
      //先向key java framework中存放三条数据
      jedis.lpush("java framework", "spring");
      jedis.lpush("java framework", "struts");
      jedis.lpush("java framework", "hibernate");
      //再取出所有数据jedis.lrange是按范围取出，
      // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
      System.out.println(jedis.lrange("java framework", 0, -1));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //set操作类型
  public static void doSet() {
    try (Jedis jedis = getJedis()) {
      //添加
      jedis.sadd("sname", "meepo");
      jedis.sadd("sname", "dota");
      jedis.sadd("sname", "poofu");
      jedis.sadd("sname", "noname");
      //移除noname
      jedis.srem("sname", "noname");

      System.out.println(jedis.smembers("sname"));//获取所有加入的value
      System.out.println(jedis.sismember("sname", "meepo"));//判断 meepo 是否是sname集合的元素
      System.out.println(jedis.srandmember("sname"));
      System.out.println(jedis.scard("sname"));//返回集合的元素个数
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //zset类型操作
  public static void doZset(){
    try (Jedis jedis = getJedis()) {
      //测试是否链接成功，返回pong则代表链接成功
      System.out.println("jedis.ping():" + jedis.ping());
      //添加元素以及关联分数到集合
      System.out.println("jedis.zadd(\"score\", 60, \"a\"):" + jedis.zadd("score", 60, "a"));
      //批量添加元素
      Map<String, Double> map = new HashMap<>();
      map.put("b", 65.0);
      map.put("c", 75.0);
      map.put("d", 90.5);
      System.out.println("jedis.zadd(\"score\", map):" + jedis.zadd("score", map));
      //获取集合中元素的个数
      System.out.println("jedis.zcard(\"score\"):" + jedis.zcard("score"));
      //按照定义的起始下标与结束下标正序遍历出相应元素，结束下标为-1则表示zset的最后元素
      System.out.println("jedis.zrange(\"score\", 1, 3):" + jedis.zrange("score", 1, 3));
      //按照定义的起始下标与结束下标倒序遍历出相应元素，结束下标为-1则表示zset的最后元素
      System.out.println("jedis.zrevrange(\"score\", 1, 3):" + jedis.zrevrange("score", 1, 3));
      //按照定义的分数区间正序遍历元素
      System.out.println("jedis.zrangeByScore(\"score\", 1, 3):" + jedis.zrangeByScore("score", 1, 3));
      //按照定义的分数区间倒序遍历元素
      System.out.println("jedis.zrevrangeByScore(\"score\", 1, 3):" + jedis.zrevrangeByScore("score", 1, 3));
      //按照定义的分数区间正序遍历元素，同时带出相应分数
      System.out.println("jedis.zrangeByScoreWithScores(\"score\", 1, 3):" + jedis.zrangeByScoreWithScores("score", 1, 3));
      //获取定义的分数区间的元素数量
      System.out.println("jedis.zcount(\"score\", 1, 3):" + jedis.zcount("score", 1, 3));
      //获取元素的score值
      System.out.println("jedis.zcount(\"score\", 1, 3):" + jedis.zscore("score", "a"));
      //正序获取元素的下标
      System.out.println("jedis.zrank(\"score\", \"a\"):" + jedis.zrank("score", "a"));
      //倒序获取元素的下标
      System.out.println("jedis.zrevrank(\"score\", \"a\"):" + jedis.zrevrank("score", "a"));
      //删除元素
      System.out.println("jedis.zrem(\"score\", \"a\"):" + jedis.zrem("score", "a"));
      //通过下标范围删除元素
      System.out.println("jedis.zremrangeByRank(\"score\", 1, 2):" + jedis.zremrangeByRank("score", 1, 2));
      //通过分数范围删除元素
      System.out.println("jedis.zremrangeByScore(\"score\", 60, 85):" + jedis.zremrangeByScore("score", 60, 85));
      //增加指定分数
      System.out.println("jedis.zremrangeByScore(\"score\", 60, 85):" + jedis.zincrby("score", 6, "a"));
      jedis.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  //redis的通用操作
  public void test() throws InterruptedException {
    try (Jedis jedis = getJedis()) {
      //keys中传入的可以用通配符
      System.out.println(
        jedis.keys("*")); //返回当前库中所有的key  [sose, sanme, name, dota, foo, sname, java framework, user, braand]
      System.out.println(jedis.keys("*name"));//返回的sname   [sname, name]
      System.out.println(jedis.del("sanmdde"));//删除key为sanmdde的对象  删除成功返回1 删除失败（或者不存在）返回 0
      System.out.println(jedis.ttl("sname"));//返回给定key的有效时间，如果是-1则表示永远有效
      jedis.setex("timekey", 10, "min");//通过此方法，可以指定key的存活（有效时间） 时间为秒
      Thread.sleep(5000);//睡眠5秒后，剩余时间将为<=5
      System.out.println(jedis.ttl("timekey"));   //输出结果为5
      jedis.setex("timekey", 1, "min");        //设为1后，下面再看剩余时间就是1了
      System.out.println(jedis.ttl("timekey"));  //输出结果为1
      System.out.println(jedis.exists("key"));//检查key是否存在
      System.out.println(jedis.rename("timekey", "time"));
      System.out.println(jedis.get("timekey"));//因为移除，返回为null
      System.out.println(jedis.get("time")); //因为将timekey 重命名为time 所以可以取得值 min

      //jedis 排序
      //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
      jedis.del("a");//先清除数据，再加入数据进行测试
      jedis.rpush("a", "1");
      jedis.lpush("a", "6");
      jedis.lpush("a", "3");
      jedis.lpush("a", "9");
      System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
      System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
      System.out.println(jedis.lrange("a", 0, -1));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

    try (Jedis jedis = getJedis()) {
      //添加
      jedis.sadd("sname", "meepo");
      jedis.sadd("sname", "dota");
      jedis.sadd("sname", "poofu");
      jedis.sadd("sname", "noname");
      //移除noname
      jedis.srem("sname", "noname");

      System.out.println(jedis.smembers("sname"));//获取所有加入的value
      System.out.println(jedis.sismember("sname", "meepo"));//判断 meepo 是否是sname集合的元素
      System.out.println(jedis.srandmember("sname"));
      System.out.println(jedis.scard("sname"));//返回集合的元素个数
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static class test {
    private int id;

    private String name;

    public test(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }
  }
}
