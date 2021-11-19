package com.example.utilservice.battle.basal.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.*;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：SftpUtil工具类(此类具有局限性，如果不能使用，可以使用hutool方法进行替代）
 * 注意：如果出现登录信息都正确但连接连接不上，可以从kex进行探查问题
 * @date 2021/8/19 0:11
 */
public class SftpUtil {

  public static
  org.slf4j.Logger log = LoggerFactory.getLogger(SftpUtil.class.getName());

  private String userName;

  private String password;

  private int port;

  private String hostName;

  private String priKeyFile;

  private String passphrase;

  Session session = null;

  Channel channel = null;

  /**
   * sftp密码连接
   *
   * @param hostName
   * @param port
   * @param userName
   * @param password
   */
  public SftpUtil(String hostName, int port, String userName, String password) {
    super();
    this.userName = userName;
    this.password = password;
    this.port = port;
    this.hostName = hostName;
  }

  /**
   * sftp密钥连接
   *
   * @param hostName
   * @param port
   * @param userName
   * @param priKeyFile
   * @param passphrase
   */
  public SftpUtil(String hostName, int port, String userName, String priKeyFile, String passphrase) {
    super();
    this.userName = userName;
    this.port = port;
    this.hostName = hostName;
    this.priKeyFile = priKeyFile;
    this.passphrase = passphrase;
  }

  public ChannelSftp connect() {
    JSch jsch = new JSch();
    try {
      if (port > 0) {
        session = jsch.getSession(userName, hostName, port);
      } else {
        session = jsch.getSession(userName, hostName);
      }
      if (session == null) {
        return null;
      }
      // 设置登陆主机的密码
      session.setPassword(password);// 设置密码
      Properties sshConfig = new Properties();
      sshConfig.put("StrictHostKeyChecking", "no");
      //密钥交换（英语：Key exchange，也称key establishment）
      sshConfig.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1");
      session.setConfig(sshConfig);
      session.setTimeout(20000);
      session.connect();
      // 创建sftp通信通道
      channel = (Channel) session.openChannel("sftp");
      channel.connect();
      return (ChannelSftp) channel;
    } catch (JSchException e) {
      e.getMessage();
    }
    return null;
  }

  /**
   * 密钥文件连接
   *
   * @return
   */
  public ChannelSftp priKeyConnect() {
    JSch jsch = new JSch();
    try {
      if (priKeyFile != null && !"".equals(priKeyFile)) {
        if (passphrase != null && !"".equals(passphrase)) {
          jsch.addIdentity(priKeyFile, passphrase);
        } else {
          jsch.addIdentity(priKeyFile);
        }
      }
      if (port > 0) {
        session = jsch.getSession(userName, hostName, port);
      } else {
        session = jsch.getSession(userName, hostName);
      }
      Properties config = new Properties();
      config.put("StrictHostKeyChecking", "no");
      config.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1");
      session.setConfig(config);
      session.setTimeout(20000);
      session.connect();
      channel = session.openChannel("sftp");
      channel.connect();
      return (ChannelSftp) channel;
    } catch (JSchException e) {
      e.getMessage();
    }
    return null;
  }

  /**
   * @param is   要上传的本地文件流
   * @param dsc  目标目录或文件，若是目录则上传的目标文件名和本地文件名一样
   * @param sftp
   * @return
   */
  public boolean upload(InputStream is, String dsc, ChannelSftp sftp) {
    try {
      sftp.put(is, dsc);
      return true;
    } catch (SftpException e) {
      return false;
    }
  }

  /**
   * @param remotedir  要上传到的目录
   * @param uploadFile 上传的文件
   * @param sftp
   * @return
   */
  public boolean upload(String remotedir, String uploadFile, ChannelSftp sftp) {
    FileInputStream fis = null;
    File file = null;
    try {
      sftp.cd(remotedir);
      file = new File(uploadFile);
      fis = new FileInputStream(file);
      sftp.put(fis, file.getName());
      return true;
    } catch (Exception e) {
      log.error(this.getClass().getName(), "sftp文件上传失败，原因：" + e.getMessage());
    } finally {
      if (file != null)
        file = null;
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e1) {
          log.error(e1.getMessage());
        }
      }

    }
    return false;
  }

  /**
   * 上传文件
   *
   * @param remotedir  上传sftp服务器根路径
   * @param tempFloder 日期临时目录
   * @param uploadFile 上传文件
   * @param sftp
   * @throws Exception
   */
  public void upload(String remotedir, String tempFloder, String uploadFile, ChannelSftp sftp)
    throws Exception {
    FileInputStream fis = null;
    String sftpPath = remotedir + tempFloder;
    try {
      sftp.cd(sftpPath);
    } catch (SftpException e) {
      try {
        //目录不存在，则创建文件夹
        String[] dirs = sftpPath.split("/+|\\\\+");
        String tempPath = "";
        for (String dir : dirs) {
          if (null == dir || "".equals(dir)) {
            continue;
          }
          tempPath += "/" + dir;
          try {
            sftp.cd(tempPath);
          } catch (SftpException ex) {
            sftp.mkdir(tempPath);
            sftp.cd(tempPath);
          }
        }
      } catch (Exception e1) {
        throw new Exception("创建目录失败，原因:" + e1.getMessage());
      }
    }

    try {
      File file = new File(uploadFile);
      fis = new FileInputStream(file);
      sftp.put(fis, file.getName());
    } catch (Exception e) {
      log.error(this.getClass().getName(), "文件上传失败，原因：" + e.getMessage());
      throw new Exception("文件上传失败");
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e1) {
          log.error(e1.getMessage());
        }
      }
    }
  }

  /**
   * 下载文件
   *
   * @param directory    下载目录
   * @param downloadFile 下载的文件
   * @param saveFile     存在本地的路径
   * @param sftp
   */
  public boolean download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      sftp.get(downloadFile, saveFile);
      return true;
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return false;
  }

  /**
   * 删除文件
   *
   * @param directory  要删除文件所在目录
   * @param deleteFile 要删除的文件
   * @param sftp
   */
  public void delete(String directory, String tempFloder, String deleteFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory + tempFloder);
      sftp.rm(FileUtil.file(deleteFile).getName());
    } catch (Exception e) {
      log.info(this.getClass().getName(), "远程sftp文件删除失败，原因：" + e.getMessage());
    }
  }

  /**
   * 删除文件
   *
   * @param directory  要删除文件所在目录
   * @param deleteFile 要删除的文件
   * @param sftp
   */
  public void delete(String directory, String deleteFile, ChannelSftp sftp) {
    try {
      sftp.cd(directory);
      sftp.rm(deleteFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 断开连接
   *
   * @param sftp
   */
  public void disconnected(ChannelSftp sftp) {
    if (sftp != null) {
      try {
        sftp.getSession().disconnect();
      } catch (JSchException e) {
        e.printStackTrace();
      }
      sftp.disconnect();
    }
  }

  public static void main(String[] args) {
    //工具类方式连接
    SftpUtil sftpUtil=new SftpUtil("127.0.0.1",2222,"foo","pass");
    ChannelSftp sftp=sftpUtil.connect();
    try{
      System.out.println(sftp.lpwd());
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      if(sftp!=null){
        sftp.disconnect();
      }
    }

//    //hutool工具包进行连接
//    Session session = JschUtil
//      .getSession("127.0.0.1",2222,"foo","pass");
//    ChannelSftp sftp1 = JschUtil.openSftp(session);
  }
}
