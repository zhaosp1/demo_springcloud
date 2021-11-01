package com.example.utilservice.util.net.socket;

import cn.hutool.core.thread.ThreadUtil;

public class Test {
  public static void main(String[] args) {
    ThreadUtil.excAsync(()->new Server(),false);
    ThreadUtil.excAsync(()->new Client().chat(),false);
  }
}
