package com.example.utilservice.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtil {
  private static Logger logger=Logger.getLogger(Log4jUtil.class);
  static {
    PropertyConfigurator.configure(Log4jUtil.class.getResource("").getPath()+"log4j.properties");
  }

  public static void main(String[] args) {
    System.out.println(Log4jUtil.class.getResource("").getPath());
    logger.debug("helllo");
  }

  public static void debug(Class clazz,String message){
    Log4jUtil log4jUtil=new Log4jUtil();
    logger=Logger.getLogger(Log4jUtil.class.getResource("").getPath());
    logger.debug(message);
  }
}
