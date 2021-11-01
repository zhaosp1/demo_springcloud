package com.example.utilservice.util.xml;
import cn.hutool.core.io.file.FileReader;
import org.testng.annotations.Test;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * sax解析xml是基于事件触发进行解析
 */
public class SaxDemo {

  @Test
  public void test(){
    //创建一个 SAXTransformerFactory 类对象
    SAXTransformerFactory tff = (SAXTransformerFactory)SAXTransformerFactory.newInstance();

    try {
      //通过 SAXTransformerFactory 对象创建一个 TransformerHandler 对象
      TransformerHandler handler = tff.newTransformerHandler();
      //通过 TransformerHandler 对象创建一个 Transformer 对象
      Transformer tr = handler.getTransformer();
      //设置生成的 XML 文件编码格式
      tr.setOutputProperty(OutputKeys.ENCODING, "utf-8");
      //设置生成的 XML 文件自动换行
      tr.setOutputProperty(OutputKeys.INDENT, "yes");
      //如果不存在，就创建一个新的 XML 文件
      File file = new File("C:\\Users\\alice\\Desktop\\newSchool.xml");
      if (!file.exists()) {
        file.createNewFile();
      }
      //创建一个Result 对象,并且使其与 TransformerHandler 对象关联
      Result result = new StreamResult(new FileOutputStream(file));
      handler.setResult(result);

      //利用 handler 对象进行 XML 文件内容的编写
      //打开 document
      handler.startDocument();
      //为了创建节点属性和属性值
      AttributesImpl atts = new AttributesImpl();
      //根节点开始标签
      handler.startElement("", "", "School", atts);
      //atts.clear();  //清空 atts 的值
      //设置属性和属性值
      atts.addAttribute("", "", "id", "", "1");
      //子节点开始标签
      handler.startElement("", "", "student", atts);

      atts.clear();  //清空子节点设的值
      //字节点下name节点开始标签
      handler.startElement("", "", "name", atts);
      String name="小王";
      handler.characters(name.toCharArray(), 0, name.length());
      //字节点下name节点结束标签
      handler.endElement("", "", "name");
      //子节点结束标签
      handler.endElement("", "", "student");

      //根节点结束标签
      handler.endElement("", "", "School");

      //关闭 document
      handler.endDocument();

    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }

  /**
   * 通过sax进行解析
   */
  @Test
  public void sax() {
    //下面是固定的写法
    SAXParserFactory factory = SAXParserFactory.newInstance();
    XMLReader reader;
    try {
      //得到xmlReader对象
      reader = factory.newSAXParser().getXMLReader();
      //设置内容处理器
      reader.setContentHandler(new MyContentHandler());
      reader.parse(new InputSource(new StringReader(new FileReader("C:\\Users\\alice\\Desktop\\xml.xml").readString())));

    } catch (SAXException | IOException | ParserConfigurationException e) {
      // TODO 自动生成的 catch 块
      e.printStackTrace();
    }
  }

  class MyContentHandler extends DefaultHandler{
    //当前正在解析的标签名
    private String currentTag;

    /*
     * 开始解析这个xml文件的时候触发
     */
    @Override
    public void startDocument() throws SAXException {
      System.out.println("开始解析这个文件了");
    }

    /*
     * 结束解析这个xml文件的时候触发
     */
    @Override
    public void endDocument() throws SAXException {
      System.out.println("文件解析结束");
    }

    /*
     * 开始解析每个元素的时候触发
     * <person age = 12 sex = f/>
     * <kale:name>jack<kale:name>
     * 1.uri：当前正在解析的元素的命名空间
     * 2.localName：不带前缀的这个元素的名字——>name
     * 3.qName：带前缀的这个元素命——>kale:name
     * 4.attributes：得到的元素中的属性——>age=12 set=f
     */
    @Override
    public void startElement(String uri, String localName, String qName,
      Attributes attributes) throws SAXException {
      //举例：<input type="hidden" name="UserType" id="UserType" value="1">
      currentTag = localName;//input
      System.out.println("————开始解析"+qName+"这个标签了————");

      for (int i = 0; i < attributes.getLength(); i++) {
        String name = attributes.getLocalName(i);//第一次是：type
        String value = attributes.getValue(i);//第一次是：hidden
        System.out.println(name + " = " + value);
      }

    }

    /* （非 Javadoc）
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
     * 停止解析这个元素的时候触发
     */
    @Override
    public void endElement(String uri, String localName, String qName)
      throws SAXException {
      // TODO 自动生成的方法存根
      super.endElement(uri, localName, qName);
      System.out.println("————-解析"+qName+"标签结束————");
    }

    /*
     * 得到元素中的内容，比如下面的jack
     * <name>jack<name>
     */
    @Override
    public void characters(char[] ch, int start, int length)
      throws SAXException {
      //举例：<name>jack<name>
      if (currentTag.equals("name")) {
        System.out.println("name = " + new String(ch,start,length));//会输出jack
      }
      if (currentTag.equals("age")) {
        System.out.println("age = " + new String(ch,start,length));//会输出21
      }
    }
  }
}
