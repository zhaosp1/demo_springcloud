package com.example.utilservice.battle.common.algorithm;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * java生成随机数
 */
public class RandomExample {

  //方式一——利用Math.random()来获取一个0.0-1.0的随机double数
  public static void random1(){
    System.out.println(Math.random()*10);
  }

  //方式二——利用Random类来获取一个随机数
  public static void random2(){
    Random random=new Random();
    System.out.println(random.nextInt(20));
  }

  //方式三——利用ThreadLocalRandom类来获取一个随机数，与Math.random()效果类似
  public static void random3(){
    System.out.println(ThreadLocalRandom.current().nextInt());
  }

  //方式四——利用Random类的ints来获取一个特定范围内随机数，这是jdk8的特性
  public static void random4(){
    Random random1 = new Random();
    random1.ints(9, 50, 60).forEach(System.out::println);
  }
  public static void main(String[] args) {
    random4();
  }
}
