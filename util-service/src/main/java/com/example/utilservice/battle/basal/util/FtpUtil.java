package com.example.utilservice.battle.basal.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.castor.util.concurrent.ConcurrentHashMap;
import sun.net.ftp.FtpClient;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：FtpUtil工具类
 * @date 2021/8/19 0:11
 */
public class FtpUtil {
  private final static Logger logger = Logger.getLogger(FtpUtil.class);

  /**
   * 获取FTPClient对象
   *
   * @return
   */
  public static FTPClient getFTPClient(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword)
    throws
    IOException {
    FTPClient ftpClient = new FTPClient();
    try {
      // 连接FTP服务器
      ftpClient.connect(ftpHost, ftpPort);
      // 登陆FTP服务器
      ftpClient.login(ftpUserName, ftpPassword);
      if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
        logger.error("未连接到FTP : 用户名或密码错误");
        ftpClient.disconnect();
        ftpClient = null;
      } else {
        logger.info("FTP连接成功");
      }
    } catch (SocketException e) {
      logger.error("FTP的IP地址可能错误，请正确配置。");
      ftpClient.disconnect();
      ftpClient = null;
    } catch (IOException e) {
      logger.error("FTP的端口错误,请正确配置。");
      ftpClient.disconnect();
      ftpClient = null;
    }
    return ftpClient;
  }

  public static boolean downloadSingleFile(FTPClient ftpClient, String fileName, String downloadPath,
    String localPath) {
    try {
      // 中文支持
      ftpClient.setControlEncoding("UTF-8");
      ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
      ftpClient.enterLocalPassiveMode();
      ftpClient.changeWorkingDirectory(downloadPath);

      File localFile = new File(localPath + File.separatorChar + fileName);
      OutputStream os = new FileOutputStream(localFile);
      boolean result = ftpClient.retrieveFile(fileName, os);
      logger.info("正在下载文件: " + downloadPath + "/" + fileName);
      logger.info("是否下载成功 : " + result);
      if (!result) {
        logger.info("该文件可能不存在");
        return false;
      }
      os.close();

      ftpClient.logout();
      return true;
    } catch (FileNotFoundException e) {
      logger.error("没有找到 [" + downloadPath + "] 文件.");

      return false;
    } catch (SocketException e) {
      logger.error("连接FTP失败.");

      return false;
    } catch (IOException e) {

      logger.error("文件读取错误.");
      return false;
    }
  }

  public static boolean uploadSingleFile(FTPClient ftpClient, String localPath, String localFileName,
    String uploadFileName, String uploadPath) {
    boolean success = false;
    FileInputStream in = null;
    try {
      in = new FileInputStream(new File(localPath + File.separatorChar + localFileName));
      int reply;
      if (ftpClient == null) {
        throw new Exception("未连接到FTP服务器！请检查FTP服务器对应配置！");
      }
      reply = ftpClient.getReplyCode();
      if (!FTPReply.isPositiveCompletion(reply)) {
        ftpClient.disconnect();
      }
      ftpClient.setControlEncoding("UTF-8");
      ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
      ftpClient.enterLocalPassiveMode();
      ftpClient.changeWorkingDirectory(uploadPath);

      boolean result = ftpClient.storeFile(uploadFileName, in);
      logger.info("正在上传文件: " + uploadPath + "/" + uploadFileName);
      logger.info("是否上传成功 : " + result);
      if (result == true) {
        success = true;
      }
      in.close();
      ftpClient.logout();
    } catch (FileNotFoundException e) {
      logger.error("上传文件失败，本地文件不存在：" + e.getLocalizedMessage());
      return false;
    } catch (IOException e) {
      logger.error("上传文件失败：" + e.getLocalizedMessage());
      return false;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (ftpClient.isConnected()) {
        try {
          ftpClient.disconnect();
        } catch (IOException ioe) {
        }
      }
    }
    return success;
  }

  /**
   * 返回FTP目录下的文件列表
   * by zhangycg 2020-05-14
   *
   * @param ftpDirectory
   * @return
   */
  public static List<String> getFileNameList(FTPClient ftpClient, String tempFileName) {
    List<String> list = new ArrayList<String>();
    try {
      ftpClient.enterLocalPassiveMode();
      FTPFile[] files = ftpClient.listFiles();
      for (FTPFile file : files) {
        if (file.isFile()) {
          if (file.getName().contains(tempFileName)) {
            list.add(file.getName());
          }
        }
      }
    } catch (IOException e) {
      logger.error("ftp输入输出错误" + e);
      e.printStackTrace();
    }
    return list;
  }

  public static void main(String[] args) throws IOException {
    FTPClient ftpClient = getFTPClient("127.0.0.1", 221, "alice", "123456");
    getFileNameList(ftpClient, "/upload").forEach(e -> System.out.println(e));
  }
}
