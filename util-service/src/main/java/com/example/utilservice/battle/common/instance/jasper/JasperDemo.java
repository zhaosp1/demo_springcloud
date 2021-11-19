package com.example.utilservice.battle.common.instance.jasper;

import cn.hutool.core.io.FileUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

public class JasperDemo {
  /**
   * 模板文件预览，建议格式：jrprint、jasper
   */
  public void viewReportTemplate(String filePath) {
    try {
      if (filePath.trim().endsWith("jasper")) {
        JasperDesignViewer.viewReportDesign(filePath, false);
      } else if (filePath.trim().endsWith("jrprint")) {
        JasperViewer.viewReport(filePath, false);
      }
    } catch (JRException e) {
      e.printStackTrace();
    }
  }

  /**
   * 将jrxml文件编译成jasper文件
   *
   * @param srcFilePath
   * @param descFilePath
   */
  public void compileTemplate(String srcFilePath, String descFilePath) {
    try {
      JasperCompileManager.compileReportToFile(srcFilePath, descFilePath);
      System.out.println("编译成功");
    } catch (JRException e) {
      e.printStackTrace();
    }
  }

  /**
   * 数据的填充，最终生成jrprint文件
   *
   * @param sourceTemplate
   * @param map
   * @param jrDataSource
   */
  public void fillReportToFile(String sourceTemplate, Map map, JRDataSource jrDataSource) {
    try {
      JasperFillManager.fillReportToFile(sourceTemplate, map, jrDataSource);
    } catch (JRException e) {
      e.printStackTrace();
    }
  }

  /**
   * 报表的打印
   * @param sourceTemplate
   * @param map
   * @param jrDataSource
   */
  public void printReport(String sourceTemplate, Map map, JRDataSource jrDataSource) {
    try {
      String printFileName = JasperFillManager.fillReportToFile(
        sourceTemplate, map, jrDataSource);
      if (sourceTemplate != null) {
        JasperPrintManager.printReport(printFileName, true);
      }
    } catch (JRException e) {
      e.printStackTrace();
    }
  }

  public void exportReport(){
    String sourceFileName = "d:/jasper_report_template.jasper";
    String printFileName = null;
    JRBeanCollectionDataSource beanColDataSource =
      new JRBeanCollectionDataSource(null);

    Map parameters = new HashMap();
    try {
      printFileName = JasperFillManager.fillReportToFile(sourceFileName,
        parameters, beanColDataSource);
      if (printFileName != null) {
        /**
         * 1- export to PDF
         */
        JasperExportManager.exportReportToPdfFile(printFileName,
          "d:/sample_report.pdf");

        /**
         * 2- export to HTML
         */
        JasperExportManager.exportReportToHtmlFile(printFileName,
          "d:/sample_report.html");

        /**
         * 3- export to Excel sheet
         */
        JRXlsExporter exporter = new JRXlsExporter();

        exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME,
          printFileName);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
          "d:/sample_report.xls");

        exporter.exportReport();
      }
    } catch (JRException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
//    new JasperDemo().compileTemplate("C:\\Users\\alice\\Desktop\\langfang.jrxml","C:\\Users\\alice\\Desktop\\langfang1.jasper");
//  Map map=new HashMap();
//    map.put("is_send","1");
//    new JasperDemo().fillReportToFile("C:\\Users\\alice\\Desktop\\langfang.jasper",map,null);

    new JasperDemo().printReport("C:\\Users\\alice\\Desktop\\langfang.jasper",null,new JREmptyDataSource());
  }
}
