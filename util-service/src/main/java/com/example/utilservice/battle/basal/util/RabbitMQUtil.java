package com.example.utilservice.battle.basal.util;

import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.RandomUtil;
import com.rabbitmq.client.*;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description: 练习（how2j）
 * @function：RabbitMQUtil工具
 * @author: zhaosp1
 * @date: 2021/8/21 17:13
 **/
public class RabbitMQUtil {
  public final static String EXCHANGE_NAME="fanout_exchange";

  //查看对应端口是否启动
  public static void checkServer() {
    if(NetUtil.isUsableLocalPort(15672)) {
      JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
      System.exit(1);
    }
  }

  /**
   * 广播模式生产者
   * @throws IOException
   * @throws TimeoutException
   */
  public static void doProducerOnFanout() throws IOException, TimeoutException {
    checkServer();

    //创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    //设置RabbitMQ相关信息
    factory.setHost("localhost");
    //创建一个新的连接
    Connection connection = factory.newConnection();
    //创建一个通道
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

    for (int i = 0; i < 100; i++) {
      String message = "direct 消息 " +i;
      //发送消息到队列中
      channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
      System.out.println("发送消息： " + message);
    }
    //关闭通道和连接
    channel.close();
    connection.close();
  }

  /**
   * 广播模式消费者
   * @throws IOException
   * @throws TimeoutException
   */
  public static void doConsumerOnFanout() throws IOException, TimeoutException {
    //为当前消费者取随机名
    String name = "consumer-"+ RandomUtil.randomString(5);

    //判断服务器是否启动
    checkServer();
    // 创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    //设置RabbitMQ地址
    factory.setHost("localhost");
    //创建一个新的连接
    Connection connection = factory.newConnection();
    //创建一个通道
    Channel channel = connection.createChannel();
    //交换机声明（参数为：交换机名称；交换机类型）
    channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
    //获取一个临时队列
    String queueName = channel.queueDeclare().getQueue();
    //队列与交换机绑定（参数为：队列名称；交换机名称；routingKey忽略）
    channel.queueBind(queueName,EXCHANGE_NAME,"");

    System.out.println(name +" 等待接受消息");
    //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
    // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope,
        AMQP.BasicProperties properties, byte[] body)
        throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(name + " 接收到消息 '" + message + "'");
      }
    };
    //自动回复队列应答 -- RabbitMQ中的消息确认机制
    channel.basicConsume(queueName, true, consumer);
  }
}
