package com.example.utilservice.battle.basal.util;

import cn.hutool.core.util.NetUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.swing.*;

/**
 * @description: 练习（how2j）
 * @function：active mq工具类
 * @author: zhaosp1
 * @date: 2021/8/21 15:37
 **/

//主题模式需要先开启消费者线程，否则会看不到消费的消息（主题模式只能看到消费者创建之后，不能看见没有创建前的消息）
public class ActiveMQUtil {

  public static void main(String[] args) {
    checkServer();
  }

  public static void checkServer() {
    if (NetUtil.isUsableLocalPort(8162)) {
      JOptionPane.showMessageDialog(null, "ActiveMQ 服务器未启动 ");
      System.exit(1);
    }
  }

  /**
   * 队列模式生产者
   *
   * @param url
   * @param topicName
   * @throws JMSException
   */
  public static void doProducerOnQueue(String url, String topicName) throws JMSException {
    //0. 先判断端口是否启动了  Active MQ 服务器
    ActiveMQUtil.checkServer();
    //1.创建ConnectionFactory,绑定地址
    ConnectionFactory factory = new ActiveMQConnectionFactory(url);
    //2.创建Connection
    Connection connection = factory.createConnection();
    //3.启动连接
    connection.start();
    //4.创建会话
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    //5.创建一个目标 (队列类型)
    Destination destination = session.createQueue(topicName);
    //6.创建一个生产者
    MessageProducer producer = session.createProducer(destination);

    for (int i = 0; i < 100; i++) {
      //7.创建消息
      TextMessage textMessage = session.createTextMessage("队列消息-" + i);
      //8.发送消息
      producer.send(textMessage);
      System.out.println("发送：" + textMessage.getText());
    }
    //7. 关闭连接
    connection.close();
  }

  /**
   * 队列模式消费者
   *
   * @param consumerName
   * @param url
   * @param topicName
   * @throws JMSException
   */
  public static void doConsumerOnQueue(String consumerName, String url, String topicName)
    throws JMSException {
    //0. 先判断端口是否启动了 Active MQ 服务器
    ActiveMQUtil.checkServer();
    System.out.printf("%s 消费者启动了。 %n", consumerName);

    //1.创建ConnectiongFactory,绑定地址
    ConnectionFactory factory = new ActiveMQConnectionFactory(url);
    //2.创建Connection
    Connection connection = factory.createConnection();
    //3.启动连接
    connection.start();
    //4.创建会话
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    //5.创建一个目标 （队列类型）
    Destination destination = session.createQueue(topicName);
    //6.创建一个消费者
    MessageConsumer consumer = session.createConsumer(destination);
    //7.创建一个监听器
    consumer.setMessageListener(new MessageListener() {

      public void onMessage(Message arg0) {
        // TODO Auto-generated method stub
        TextMessage textMessage = (TextMessage) arg0;
        try {
          System.out.println(consumerName + " 接收消息：" + textMessage.getText());
        } catch (JMSException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }
    });

    //8. 因为不知道什么时候有，所以没法主动关闭，就不关闭了，一直处于监听状态
    //connection.close();
  }

  /**
   * 主题模式生产者
   *
   * @param url
   * @param topicName
   * @throws JMSException
   */
  public static void doProducerOnTopic(String url, String topicName) throws JMSException {
    //0. 先判断端口是否启动了  Active MQ 服务器
    ActiveMQUtil.checkServer();
    //1.创建ConnectiongFactory,绑定地址
    ConnectionFactory factory = new ActiveMQConnectionFactory(url);
    //2.创建Connection
    Connection connection = factory.createConnection();
    //3.启动连接
    connection.start();
    //4.创建会话
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    //5.创建一个目标 (主题类型)
    Destination destination = session.createTopic(topicName);
    //6.创建一个生产者
    MessageProducer producer = session.createProducer(destination);

    for (int i = 0; i < 100; i++) {
      //7.创建消息
      TextMessage textMessage = session.createTextMessage("主题消息-" + i);
      //8.发送消息
      producer.send(textMessage);
      System.out.println("发送：" + textMessage.getText());
    }
    //7. 关闭连接
    connection.close();
  }

  /**
   * 主题模式消费者
   *
   * @param url
   * @param topicName
   * @throws JMSException
   */
  public static void doConsumerOnTopic(String consumerName, String url, String topicName)
    throws JMSException {
    //0. 先判断端口是否启动了 Active MQ 服务器
    ActiveMQUtil.checkServer();
    System.out.printf("%s 消费者启动了。 %n", consumerName);
    //1.创建ConnectiongFactory,绑定地址
    ConnectionFactory factory = new ActiveMQConnectionFactory(url);
    //2.创建Connection
    Connection connection = factory.createConnection();
    //3.启动连接
    connection.start();
    //4.创建会话
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    //5.创建一个目标 （主题类型）
    Destination destination = session.createTopic(topicName);
    //6.创建一个消费者
    MessageConsumer consumer = session.createConsumer(destination);
    //7.创建一个监听器
    consumer.setMessageListener(new MessageListener() {

      public void onMessage(Message arg0) {
        // TODO Auto-generated method stub
        TextMessage textMessage = (TextMessage) arg0;
        try {
          System.out.println(consumerName + " 接收消息：" + textMessage.getText());
        } catch (JMSException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

      }
    });

    //8. 因为不知道什么时候有，所以没法主动关闭，就不关闭了，一直处于监听状态
    //connection.close();

  }
}