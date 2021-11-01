package com.example.utilservice.util.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class JDomDemo {
  @Test
  public void test() {
    try {
      JDomDemo JDomDemo = new JDomDemo();
      String[] ipAddress = { "172.16.0.1", "172.16.0.2" };
      String[] testAddress = { "192.168.1.0/24", "192.168.2.0/24" };
      System.out.println("生成 mxl 文件...");
      JDomDemo.BuildXMLDoc(2, ipAddress, testAddress);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * jdom方式生成xml
   *
   * @param number
   * @param ipAddress
   * @param testAddress
   * @throws IOException
   * @throws JDOMException
   */
  public void BuildXMLDoc(int number, String ipAddress[], String testAddress[])
    throws IOException, JDOMException {

    Element equipments = new Element("equipments");//建立根节点
    Document doc = new Document(equipments);//用把根节点创建一个Document

    Element equipmentsNum = new Element("equipments-number");//创建根节点下的子节点
    equipmentsNum.setText(Integer.toString(number));
    equipments.addContent(equipmentsNum);//把该子节点加入父节点
    //循环创建子节点，并加入到父节点中
    for (int i = 1; i <= number; i++) {
      Element equipment = new Element("equipment");
      equipment.setAttribute("id", "" + i);//添加节点属性并赋值

      Element loginInfo = new Element("login-info");
      loginInfo.addContent(new Element("address").setText(ipAddress[i - 1])); //创建节点，给节点赋值，然后加入到他的父节点
      loginInfo.addContent(new Element("telnet-password").setText("CISCO"));
      loginInfo.addContent(new Element("enable-password").setText("CISCO"));
      equipment.addContent(loginInfo);

      Element testCommands = new Element("test-commands");
      testCommands.addContent(new Element("command").setText("show ip route"));
      equipment.addContent(testCommands);

      Element testReturn = new Element("test-returns");
      testReturn.addContent(new Element("return").setText(testAddress[i - 1]));
      equipment.addContent(testReturn);

      equipments.addContent(equipment);
    }

    XMLOutputter xmlOut = new XMLOutputter(
      Format.getPrettyFormat());//new一个XMLOutputter，采用PrettyFormat格式（生成的XML可以自动换行）
    xmlOut.output(doc, new FileOutputStream("C:\\Users\\alice\\Desktop\\autoTest.xml"));//将生成的XML文件输出到文件
  }

  /**
   * jdom方式解析xml
   */
  @Test
  public void parseXML() {
    SAXBuilder builder = new SAXBuilder();//选用jdom中的SAXBuilder解析器解析xml16
    try {
      Document doc = builder.build("C:\\Users\\alice\\Desktop\\autoTest.xml");//从传入xml文件中提取出doc
      Element equipments = doc.getRootElement();//从doc中得到根节点，赋值给equipments
      List equipmentList = equipments.getChildren("equipment");//在equipments中得到名字为equipment的子节点List
      for (Iterator iter = equipmentList.iterator(); iter.hasNext(); ) {//循环List
        Element equipment = (Element) iter.next();
        String id = equipment.getAttributeValue("id");//得到equipment的属性id，并把它的值赋值给字符串
        String ipAddress = equipment.getChild("login-info").getChild("address").getText();//两重子节点的Text赋值给字符串
        String testAddress = equipment.getChild("test-returns").getChild("return").getText();
        System.out.println(id + "    " + ipAddress + "    " + testAddress);
      }

      XMLOutputter outputter = new XMLOutputter();  //保存Document的修改到XML文件中
      outputter.output(doc, new FileOutputStream("C:\\Users\\alice\\Desktop\\autoTest.xml"));

    } catch (
      JDOMException e) {
      e.printStackTrace();
    } catch (
      IOException e) {
      e.printStackTrace();
    }

  }
}
