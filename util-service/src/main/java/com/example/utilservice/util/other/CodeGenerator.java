package com.example.utilservice.util.other;

/**
 * 如果需要定义一个全局化代码生成系统，则需要进行系统化设计
 */
public class CodeGenerator {
  public static final String LABEL_BLANK = " ";

  public static final String LABEL_TABLE = "\t";

  public static final String LABEL_LINE = "\n";

  public static final String LABEL_VOID = "void";

  public static final String LABEL_PUBLIC = "public";

  public static final String LABEL_PROTECTED = "protected";

  public static final String LABEL_DEFAULT = "default";

  public static final String LABEL_PRIVATE = "private";

  public static final String LABEL_LEFT_BRACKET = "(";

  public static final String LABEL_RIGHT_BRACKET = ")";

  public static final String LABEL_LEFT_BRACE = "{";

  public static final String LABEL_RIGHT_BRACE = "}";

  public static final String LABEL_FINAL = "final";

  public static final String LABEL_STATIC = "static";

  public static final String LABEL_SYNCHRONIZED = "synchronized";

  public static final String LABEL_VOLATILE = "volatile";

  /**
   * 生成一个自定义类
   * @param clazz 类名
   * @param properties 成员变量
   * @param methods 成员方法
   * @param nums
   * @return
   */
  public static String createClass(String clazz, String[] properties, String[] methods, int nums) {
    String symbol = getSymbol(LABEL_BLANK, nums);
    StringBuilder sb = new StringBuilder();
    sb.append(getPackage("test"));
    sb.append("public class ").append(clazz + "{\n");
    sb.append(getProperties(properties, symbol));
    sb.append(getMethods(methods, symbol));
    sb.append("}\n");
    return sb.toString();
  }

  /**
   * 获取包定义
   * @param packageName
   * @return
   */
  private static String getPackage(String packageName){
    return "package "+packageName+";\n\n";
  }

  /**
   * 获取成员变量定义
   * @param properties
   * @param symbol
   * @return
   */
  private static String getProperties(String[] properties,String symbol){
    StringBuilder sb=new StringBuilder();
    for (String property : properties) {
      sb.append(symbol).append("private String ").append(property).append(";\n");
    }
    sb.append("\n");
    return sb.toString();
  }

  /**
   * 获取成员方法定义
   * @param methods
   * @param symbol
   * @return
   */
  private static String getMethods(String[] methods,String symbol){
    StringBuilder sb=new StringBuilder();
    for (String method : methods) {
      sb.append(symbol).append("public void ").append(method).append("(){\n\n").append(symbol).append("}\n");
    }
    return sb.toString();
  }

  /**
   * 获取定制的字符串
   *
   * @param model 模板字符
   * @param nums  字符个数
   * @return
   */
  private static String getSymbol(String model, int nums) {
    if (nums > 0 && nums < Integer.MAX_VALUE) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < nums; i++) {
        sb.append(model);
      }
      return sb.toString();
    } else {
      return "";
    }

  }

  public static void main(String[] args) {
    System.out.println(
      createClass("Demo", new String[] { "id", "name", "age", "birth" }, new String[] { "test1", "test2" },
        2));
  }
}
