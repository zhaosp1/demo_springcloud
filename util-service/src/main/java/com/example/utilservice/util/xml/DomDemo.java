package com.example.utilservice.util.xml;

import cn.hutool.core.io.FileUtil;
import org.testng.annotations.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Alexia
 * <p>
 * DOM 解析XML文档
 */
public class DomDemo implements XmlDocument {
  private Document document;

  @Test
  public void test() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(FileUtil.file("C:\\Users\\alice\\Desktop\\xml.xml"));

      Element root = document.getDocumentElement();
      parseElement(root);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * dom生成xml
   */
  @Test
  public void createXml() {
    try {
      //创建一个 DocumentBuilderFactory 对象
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      //创建DocumentBuilder对象
      DocumentBuilder db = dbf.newDocumentBuilder();
      //创建 Document 对象
      Document document = db.newDocument();

      //隐藏 XML文件 standalone 属性
      document.setXmlStandalone(true);
      //创建根节点
      Element school = document.createElement("school");
      //创建子节点
      Element student = document.createElement("student");
      //创建student的子节点
      Element name = document.createElement("name");
      Element age = document.createElement("age");
      Element address = document.createElement("address");

      //给 name 节点添加 文本内容
      name.setTextContent("小明");
      age.setTextContent("18");
      address.setTextContent("北京市海定区五道口");

      //把子节点 添加到 student 节点下
      student.appendChild(name);
      student.appendChild(age);
      student.appendChild(address);

      //向 studet 节点添加属性和属性值
      student.setAttribute("id", "1");
      //向 school 添加子节点
      school.appendChild(student);
      //将 根节点(已经包含子节点    )添加到dom树中
      document.appendChild(school);

      //..将 dom树转换为 XML文件
      //创建 TransformerFactory 对象
      TransformerFactory tff = TransformerFactory.newInstance();
      //创建 Transformer 对象
      Transformer tf = tff.newTransformer();
      //设置生成的 XML 文件自动换行
      tf.setOutputProperty(OutputKeys.INDENT, "yes");
      //使用 Transformer 的 transform 方法把Dom树转换成  XML 文件
      tf.transform(new DOMSource(document), new StreamResult(FileUtil.file("C:\\Users\\alice\\Desktop\\School_01.xml")));

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (TransformerException e) {
      e.printStackTrace();
    }
  }

  /**
   * 仅能实现两层树结构的访问
   *
   * @param fileName
   */
  @Override
  public void parserXml(String fileName) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document document = db.parse(fileName);
      NodeList users = document.getChildNodes();

      for (int i = 0; i < users.getLength(); i++) {
        Node user = users.item(i);
        NodeList userInfo = user.getChildNodes();

        for (int j = 0; j < userInfo.getLength(); j++) {
          Node node = userInfo.item(j);
          NodeList userMeta = node.getChildNodes();

          for (int k = 0; k < userMeta.getLength(); k++) {
            if (userMeta.item(k).getNodeName() != "#text")
              System.out.println(userMeta.item(k).getNodeName()
                + ":" + userMeta.item(k).getTextContent());
          }

          System.out.println();
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * dom递归实现多层树的访问
   *
   * @param element
   */
  private static void parseElement(Element element) {
    String tagName = element.getNodeName();

    System.out.print("<" + tagName);

    // element元素的所有属性构成的NamedNodeMap对象，需要对其进行判断
    NamedNodeMap map = element.getAttributes();

    // 如果存在属性，则打印属性
    if (null != map) {
      for (int i = 0; i < map.getLength(); i++) {
        // 获得该元素的每一个属性
        Attr attr = (Attr) map.item(i);

        // 属性名和属性值
        String attrName = attr.getName();
        String attrValue = attr.getValue();

        // 注意属性值需要加上引号，所以需要\转义
        System.out.print(" " + attrName + "=\"" + attrValue + "\"");
      }
    }

    // 关闭标签名
    System.out.print(">");

    // 至此已经打印出了元素名和其属性
    // 下面开始考虑它的子元素
    NodeList children = element.getChildNodes();

    for (int i = 0; i < children.getLength(); i++) {

      // 获取每一个child
      Node node = children.item(i);
      // 获取节点类型
      short nodeType = node.getNodeType();

      if (nodeType == Node.ELEMENT_NODE) {
        // 如果是元素类型，则递归输出
        parseElement((Element) node);
      } else if (nodeType == Node.TEXT_NODE) {
        // 如果是文本类型，则输出节点值，及文本内容
        System.out.print(node.getNodeValue());
      } else if (nodeType == Node.COMMENT_NODE) {
        // 如果是注释，则输出注释
        System.out.print("<!--");

        Comment comment = (Comment) node;

        // 注释内容
        String data = comment.getData();

        System.out.print(data);

        System.out.print("-->");
      }
    }

    // 所有内容处理完之后，输出，关闭根节点
    System.out.print("</" + tagName + ">");
  }

}