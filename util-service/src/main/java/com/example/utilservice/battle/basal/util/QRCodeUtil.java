package com.example.utilservice.battle.basal.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaosp1
 * @description: 练习（how2j）
 * @function：使用谷歌的zxing生成二维码工具类
 * @date 2021/8/19 0:13
 */
public class QRCodeUtil {
  // 二维码宽度
  private static final int width = 100;
  // 二维码高度
  private static final int height = 100;
  // 二维码默认文件格式
  private static final String format = "png";
  // 二维码参数
  private static final Map<EncodeHintType, Object> hints = new HashMap();

  static {
    // 字符编码
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    // 容错等级：L、M、Q、H，其中L最低，H最高
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    // 二维码图片边距
    hints.put(EncodeHintType.MARGIN, 2);
  }

  /**
   * 返回一个BufferedImage对象
   *
   * @param content 二维码内容
   * @param width   宽
   * @param height  高
   * @return BufferedImage
   * @throws WriterException
   */
  public static BufferedImage toBufferedImage(String content, int width, int height) throws WriterException {
    BitMatrix bitMatrix = buildBitMatrix(content, width, height);
    return MatrixToImageWriter.toBufferedImage(bitMatrix);
  }

  /**
   * 将二维码输出到一个流中
   *
   * @param content 二维码内容
   * @param stream  输出流
   * @param width   宽
   * @param height  高
   * @throws WriterException
   * @throws IOException
   */
  public static void writeToStream(String content, OutputStream stream, int width, int height) throws WriterException, IOException {
    BitMatrix bitMatrix = buildBitMatrix(content, width, height);
    MatrixToImageWriter.writeToStream(bitMatrix, format, stream);
  }

  private static BitMatrix buildBitMatrix(String content, int width, int height) throws WriterException {
    if (content == null || content.trim().length() == 0) {
      throw new IllegalArgumentException("二维码内容不能为空");
    }
    return new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
  }

  /**
   * 生成二维码图片文件
   *
   * @param content 二维码内容
   * @param path    文件保存路径
   * @param width   宽
   * @param height  高
   * @throws WriterException
   * @throws IOException
   */
  public static void createQRCode(String content, String path, int width, int height) throws WriterException, IOException {
    BitMatrix bitMatrix = buildBitMatrix(content, width, height);
    MatrixToImageWriter.writeToPath(bitMatrix, format, new File(path).toPath());
  }

  public static void main(String[] args) {
    try {
      QRCodeUtil.createQRCode("https://how2j.cn/k/qrcode/qrcode-java-qrcode/1635.html#nowhere", "C:\\Users\\alice\\Desktop\\temp.png", width, height);
      System.out.println("生成二维码成功");
    } catch (WriterException | IOException e) {
      System.out.println(e.getMessage());
    }
  }
}