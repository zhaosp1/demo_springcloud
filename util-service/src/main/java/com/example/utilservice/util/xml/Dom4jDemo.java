package com.example.utilservice.util.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Dom4jDemo {

  /**
   * dom4j生成xml
   *
   * @param file
   * @throws IOException
   */
  public void creatXml(File file) throws IOException {
    //创建一个文档模型
    Document document = DocumentHelper.createDocument();
    //定义一个根节点
    Element root = document.addElement("parameters");
    //根节点下添加子节点
    Element paramer1 = root.addElement("tao");
    //节点添加属性
    paramer1.addAttribute("taodashen", "淘大婶");
    //节点添加文本
    paramer1.addText("大婶好");
    Element paramer2 = root.addElement("zhou");
    paramer2.addAttribute("xiaozhou", "mengwa");
    paramer2.addText("萌娃娃");
    Element paramer3 = root.addElement("xu");
    paramer3.addAttribute("xinyi", "teacher");
    Element guodaxia = paramer3.addElement("guowei");
    guodaxia.addAttribute("name", "guo");
    guodaxia.addAttribute("ming", "daxia");
    guodaxia.addText("郭大侠");
    //创建XML格式
    //StringWriter stringWriter = new StringWriter();
    OutputFormat xmlFormat = new OutputFormat();
    xmlFormat.setEncoding("UTF-8");
    xmlFormat.setNewlines(true);
    xmlFormat.setIndent("      ");
    FileWriter fileWriter = new FileWriter(file);
    XMLWriter xmlWriter = new XMLWriter(fileWriter, xmlFormat);
    xmlWriter.write(document);
    xmlWriter.close();
  }

  //获取节点名，节点属性
  public void iteratorCherk(Element element) {
    List<Element> elements = element.elements();
    for (Element ele : elements) {
      List<Attribute> attributeList = ele.attributes();
      String name = ele.getName();
      String text = ele.getTextTrim();
      System.out.println(name + " " + text + "  " + "节点");
      for (Attribute att : attributeList) {
        String aname = att.getName();
        String atext = att.getText();
        System.out.println(aname + " " + atext + "  " + "属性");
      }
      System.out.println("----------------------------------------");
      iteratorCherk(ele);
    }
  }

  //dom4j解析XML
  public void analysisXml(File file) throws Exception {
    //
    SAXReader reader = new SAXReader();
    Document document = reader.read(file);
    Element root = document.getRootElement();
    iteratorCherk(root);

  }

  public static void main(String[] args) throws Exception {

    Dom4jDemo Dom4jDemo = new Dom4jDemo();
    File file = new File("C:\\Users\\alice\\Desktop\\dom4j.xml");
    Dom4jDemo.creatXml(file);
    Dom4jDemo.analysisXml(file);
  }
}