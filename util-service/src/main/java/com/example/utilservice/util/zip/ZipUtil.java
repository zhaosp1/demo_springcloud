package com.example.utilservice.util.zip;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 使用jdk类定义的zip文件压缩工具类，特点是兼容性好
 */
public class ZipUtil {

  private static final int BUFFER_SIZE = 2 * 1024;

  /**
   * @param srcDir
   *            需要压缩的文件夹
   * @param zipPath
   *            压缩文件目录
   * @param zipFileName
   *            压缩文件的名称
   * @throws RuntimeException
   * @throws FileNotFoundException
   */
  public static void toZip(String srcDir, String zipPath, String zipFileName)
    throws RuntimeException, FileNotFoundException {
    long start = System.currentTimeMillis();
    File zipDir = new File(zipPath);
    if (!zipDir.exists() || !zipDir.isDirectory()) {
      zipDir.mkdirs();
    }

    File zipFile = new File(zipPath, zipFileName);
    FileOutputStream out = new FileOutputStream(zipFile);
    ZipOutputStream zos = null;
    try {
      zos = new ZipOutputStream(out);
      File sourceFile = new File(srcDir);
      compress(sourceFile, zos, sourceFile.getName(), false);
      long end = System.currentTimeMillis();
      System.out.println("压缩完成，耗时：" + (end - start) + " ms");
    } catch (Exception e) {
      throw new RuntimeException("zip error from ZipUtils", e);
    } finally {
      if (zos != null) {
        try {
          zos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * @param sourceFile
   *            需要压缩的文件目录
   * @param zos
   *            zip输出流
   * @param name
   *            压缩后的zip名称
   * @param KeepDirStructure
   *            是否保留原来的目录结构（false:不保留；true:保留）
   * @throws Exception
   */
  private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure)
    throws Exception {
    byte[] buf = new byte[BUFFER_SIZE];
    if (sourceFile.isFile()) {
      zos.putNextEntry(new ZipEntry(name));
      int len;
      FileInputStream in = new FileInputStream(sourceFile);
      while ((len = in.read(buf)) != -1) {
        zos.write(buf, 0, len);
      }
      zos.closeEntry();
      in.close();
    } else {
      File[] listFiles = sourceFile.listFiles();
      if (listFiles == null || listFiles.length == 0) {
        zos.putNextEntry(new ZipEntry(name + "/"));
        zos.closeEntry();
      } else {
        for (File file : listFiles) {
          if (KeepDirStructure) {
            compress(file, zos, name + "/" + file.getName(), true);
          } else {
            compress(file, zos, file.getName(), true);
          }
        }
      }
    }
  }

  /**
   * 压缩成ZIP 方法2
   * @param files
   * @param zipPath
   * @param zipFileName
   * @throws RuntimeException
   */
  public static void toZip(File[] files, String zipPath, String zipFileName) throws RuntimeException {

    long start = System.currentTimeMillis();
    ZipOutputStream zos = null;
    FileOutputStream out = null;
    try {
      File zipDir = new File(zipPath);
      if (!zipDir.exists() || !zipDir.isDirectory()) {
        zipDir.mkdirs();
      }

      File zipFile = new File(zipPath, zipFileName);
      out = new FileOutputStream(zipFile);
      zos = new ZipOutputStream(out);
      for (File srcFile : files) {
        byte[] buf = new byte[BUFFER_SIZE];
        zos.putNextEntry(new ZipEntry(srcFile.getName()));
        int len;
        FileInputStream in = new FileInputStream(srcFile);
        while ((len = in.read(buf)) != -1) {
          zos.write(buf, 0, len);
        }
        zos.closeEntry();
        in.close();
      }
      long end = System.currentTimeMillis();
      System.out.println("压缩完成，耗时：" + (end - start) + " ms");
    } catch (Exception e) {
      throw new RuntimeException("zip error from ZipUtils", e);
    } finally {
      if (zos != null) {
        try {
          zos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 解压文件到指定目录
   */
  @SuppressWarnings("rawtypes")
  public static void unZipFiles(String zipPath, String descDir) {
    File zipFile = new File(zipPath);
    File pathFile = new File(descDir);
    if (!pathFile.exists()) {
      pathFile.mkdirs();
    }
    // 解决zip文件中有中文目录或者中文文件
    ZipFile zip = null;
    try {
      zip = new ZipFile(zipFile, Charset.forName("GBK"));

      for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
        // 输出文件路径信息
        FileOutputStream out = null;
        InputStream in = null;
        try {
          ZipEntry entry = (ZipEntry) entries.nextElement();
          String zipEntryName = entry.getName();
          in = zip.getInputStream(entry);
          String outPath = descDir + File.separator + zipEntryName;
          // 判断路径是否存在,不存在则创建文件路径
          // File file = new File(outPath.substring(0, outPath.lastIndexOf("/")));
          File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
          if (!file.exists()) {
            file.mkdirs();
          }
          // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
          if (new File(outPath).isDirectory()) {
            continue;
          }

          out = new FileOutputStream(outPath);
          byte[] buf1 = new byte[1024];
          int len;
          while ((len = in.read(buf1)) > 0) {
            out.write(buf1, 0, len);
          }

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          if (out != null) {
            try {
              out.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
          if (in != null) {
            try {
              in.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }

        }
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    } finally {
      if (zip != null) {
        try {
          zip.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }
  }

  /**
   * 测试
   */

  public static void main(String[] args) throws FileNotFoundException {

    unZipFiles("C:\\Users\\luck dog\\Desktop\\100598975380016666_20210208_6.zip","C:\\Users\\luck dog\\Desktop\\");

  }

}
