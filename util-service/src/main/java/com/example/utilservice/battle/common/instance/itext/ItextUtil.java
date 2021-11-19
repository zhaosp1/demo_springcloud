package com.example.utilservice.battle.common.instance.itext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class ItextUtil {
  /** 生成的PDF文件的路径。 */
  public static final String RESULT = "D:/results/part1/chapter01/hello.pdf";

  /**
   *   创建一个PDF文件：hello.pdf
   *   @param    args    no arguments needed
   */
  public static void main(String[] args) throws Exception {
    ItextUtil itextUtil=new ItextUtil();
//    itextUtil.createPdf("C:\\Users\\alice\\Desktop\\jhon999.pdf");
//    itextUtil.addImage();
    itextUtil.appendImage();
  }


  public void addImage() throws Exception{
    Document document = new Document();
    try
    {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\alice\\Desktop\\seal.pdf"));
      document.open();
//      document.add(new Paragraph("Image Example"));

      //Add Image
      Image image1 = Image.getInstance("C:\\Users\\alice\\Desktop\\seal.png");
      //Fixed Positioning
      image1.setAbsolutePosition(100f, 550f);
      //Scale to new height and new width of image
      image1.scaleAbsolute(200, 200);
      //Add to document
      document.add(image1);

//      String imageUrl = "C:\\Users\\alice\\Desktop\\seal.png";
//      Image image2 = Image.getInstance(new URL(imageUrl));
//      document.add(image2);

      document.close();
      writer.close();
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  /**
   *   创建PDF文档.
   * @param filename 新PDF文档的路径
   */
  public void createPdf(String filename) throws DocumentException, IOException {
    // 第一步 创建文档实例
    Document document = new Document();
    // 第二步 获取PdfWriter实例
    PdfWriter.getInstance(document, new FileOutputStream(filename));
    // 第三步 打开文档
    document.open();
    // 第四步 添加段落内容
    document.add(new Paragraph("Hello World!"));
    // 第五部 操作完成后必须执行文档关闭操作。
    document.close();
  }

public void appendImage() throws Exception{
  PdfReader pdfReader = null;
  PdfStamper pdfStamper = null;
  try {
    String newPdfPath = "C:\\Users\\alice\\Desktop\\seal1.pdf";
    String srcPdfPath = "C:\\Users\\alice\\Desktop\\seal.pdf";
    pdfReader = new PdfReader(srcPdfPath);
    FileOutputStream out = new FileOutputStream(newPdfPath);
    pdfStamper = new PdfStamper(pdfReader, out);
    PdfContentByte pdfContentByte = pdfStamper.getOverContent(1);

    System.out.println(pdfReader.getPageSizeWithRotation(1));
  // 二维码宽度 单位pt
    Image qrcodeImage = Image.getInstance("C:\\Users\\alice\\Desktop\\seal.png");
    qrcodeImage.setAbsolutePosition(100, 550);
    qrcodeImage.scaleAbsolute(50, 50);


//    // pdf 坐标 从左到右 从下到上 单位pt
//    qrcodeImage.setAbsolutePosition(0, 0);
    pdfContentByte.addImage(qrcodeImage);
    pdfContentByte.stroke();
    pdfStamper.close();
  }catch (Exception ex) {
    System.out.println(ex.getMessage());
  }finally {
    if (pdfReader != null) {
      pdfReader.close();
    }
  }
}

  //添加文字
  public void addContent() throws IOException, DocumentException {
    String filePath = "C:\\Users\\fan\\Desktop\\测试模板变量_多页.pdf";
    String savePath = "C:\\Users\\fan\\Desktop\\测试模板变量6.pdf";

    BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", false);
    Font font = new Font(baseFont);

    PdfReader reader = new PdfReader(new FileInputStream(filePath));
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(savePath));


    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
      PdfContentByte over = stamper.getOverContent(i);
      ColumnText columnText = new ColumnText(over);
      // llx 和 urx  最小的值决定离左边的距离. lly 和 ury 最大的值决定离下边的距离
      columnText.setSimpleColumn(272, 760, 350, 300);
      Paragraph elements = new Paragraph(0, new Chunk("我是甲方"));
      // 设置字体，如果不设置添加的中文将无法显示
      elements.setFont(font);
      columnText.addElement(elements);
      columnText.go();
    }
    stamper.close();
  }

}
