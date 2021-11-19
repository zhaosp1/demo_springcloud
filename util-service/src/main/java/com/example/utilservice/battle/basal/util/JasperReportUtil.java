package com.example.utilservice.battle.basal.util;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
//import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：JasperReportUtil工具类
 * @date 2021/8/19 0:13
 */
public class JasperReportUtil {
  //JasperReportFill填充导出
  public static void fillAndExport(String sourceFileName, Map map, String uploadFileName) {
//    String sourceFileName = "c://tools/jasperreports-5.0.1/"
//      + "test/jasper_report_template.jasper";
    String printFileName = null;
    Map parameters = new HashMap();
    try {
      printFileName = JasperFillManager.fillReportToFile(sourceFileName,
        parameters, new JREmptyDataSource());
      if (printFileName != null) {
        /**
         * 1- export to PDF
         */
        JasperExportManager.exportReportToPdfFile(printFileName,
          "C://sample_report.pdf");
        /**
         * 2- export to HTML
         */
        JasperExportManager.exportReportToHtmlFile(printFileName,
          "C://sample_report.htmll");
        /**
         * 3- export to Excel sheet
         */
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
          printFileName);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          "C://sample_report.xls");
        exporter.exportReport();
      }
    } catch (JRException e) {
      e.printStackTrace();
    }
  }

  /**
   * 查询流水信息，通过数据填充ireport模板，来生成一个pdf文件保存在本地路径
   *
   * @param parameters 流水参数信息
   * @param localPath  指定的本地路径
   */
  public static void fillTemplate(Map parameters, String localPath, String reportModelFile) {
    parameters.put("is_send", "付款");
    parameters.put("pay_name", "hello");
    parameters.put("pay_acc", "13545481564");
    parameters.put("pay_bank", "82532156");
    parameters.put("payee_name", "");
    parameters.put("payee_acc", "");
    ByteArrayOutputStream outPut = new ByteArrayOutputStream();
    FileOutputStream outputStream = null;
    File file = new File(localPath + "\\jhon.pdf");
//    String reportModelFile = "C:\\Users\\demo\\Desktop\\july.jasper";//项目路径下源码

    try {
      JasperPrint jasperPrint = JasperFillManager.fillReport(reportModelFile,
        parameters, new JREmptyDataSource());
      JRAbstractExporter exporter = new JRPdfExporter();
      //创建jasperPrint
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      //生成输出流
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outPut);
      //屏蔽copy功能
      exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
      //加密
      exporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY, Boolean.TRUE);
      exporter.exportReport();
      outputStream = new FileOutputStream(file);
      outputStream.write(outPut.toByteArray());
    } catch (JRException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        outPut.flush();
        outPut.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 基于返回的印章图片进行签章合成
   *
   * @param urljPG 水印图片
   * @param urlPdf PDF路径
   * @Description:
   */
  public static void imagePdf(String urljPG, String urlPdf) throws Exception {
    // 获取去除后缀的文件路径
    String fileName = urlPdf.substring(0, urlPdf.lastIndexOf("."));
    //把截取的路径，后面追加四位随机数
    String pdfUrl = fileName + (int) ((Math.random() * 9 + 1) * 1000) + ".pdf";
    //要加水印的原pdf文件路径
    PdfReader reader = new PdfReader(urlPdf, "PDF".getBytes());
    //加了水印后要输出的路径
    PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(pdfUrl));
    // 插入水印
    Image img = Image.getInstance(urljPG);
    //原pdf文件的总页数
    int pageSize = reader.getNumberOfPages();
    //印章位置
    img.setAbsolutePosition(395, 205);
    //印章大小
    img.scalePercent(50);
    for (int i = 1; i <= pageSize; i++) {
      //背景被覆盖
//            PdfContentByte under = stamp.getUnderContent(i);
      //文字被覆盖
      PdfContentByte under = stamp.getOverContent(i);
      //添加电子印章
      under.addImage(img);
    }
    // 关闭
    stamp.close();
    //关闭
    reader.close();
  }

  //实现图片与字节数组的转换
  static byte[] image2Bytes(String imgSrc) throws Exception {
    FileInputStream fin = new FileInputStream(new File(imgSrc));
    //可能溢出,简单起见就不考虑太多,如果太大就要另外想办法，比如一次传入固定长度byte[]
    byte[] bytes = new byte[fin.available()];
    //将文件内容写入字节数组，提供测试的case
    fin.read(bytes);

    fin.close();
    return bytes;
  }

  //java实现字节数组与图片文件的转换
  static void buff2Image(byte[] b, String tagSrc) throws Exception {
    FileOutputStream fout = new FileOutputStream(tagSrc);
    //将字节写入文件
    fout.write(b);
    fout.close();
  }

  /**
   * 将字节流转换成文件
   *
   * @param filename
   * @param data
   * @throws Exception
   */
  public static void saveFile(String filename, byte[] data) throws Exception {
    if (data != null) {
      String filepath = "D:\\" + filename;
      File file = new File(filepath);
      if (file.exists()) {
        file.delete();
      }
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(data, 0, data.length);
      fos.flush();
      fos.close();
    }
  }

  /**
   * 导出pdf文件
   *
   * @param template       模板文件
   * @param map            上传参数
   * @param uploadFileName 待上传文件绝对路径
   * @throws FileNotFoundException
   * @throws JRException
   */
  public static void exportPdfFile(File template, Map map, File temp, String uploadFileName)
    throws Exception {
    File file = new File(uploadFileName);
//    File2CodeUtil.base64StringToImage((String)map.get("img"),temp);
    map.put("img", temp);
    JasperPrint jasperPrint = JasperFillManager
      .fillReport(new FileInputStream(template),
        map, new JREmptyDataSource());
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
      new FileOutputStream(file)));
    exporter.exportReport();
    if (file != null)
      file = null;
    if (temp != null)
      temp.delete();
  }

  /**
   * 导出pdf文件
   *
   * @param template       模板文件
   * @param map            上传参数
   * @param uploadFileName 待上传文件绝对路径
   * @throws FileNotFoundException
   * @throws JRException
   */
  public static void exportPdfFileForNewModel(File template, Map map, File temp, String uploadFileName)
    throws Exception {
    File file = new File(uploadFileName);
    JasperPrint jasperPrint = JasperFillManager
      .fillReport(new FileInputStream(template),
        map, new JREmptyDataSource());
    JRPdfExporter exporter = new JRPdfExporter();
    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
      new FileOutputStream(file)));
    exporter.exportReport();
    if (file != null)
      file = null;
    if (temp != null)
      temp.delete();
  }
}
