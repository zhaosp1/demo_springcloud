//package com.example.utilservice.util.http;
//
//import okhttp3.*;
//
//import java.io.IOException;
//
///**
// * http客户端工具类——okhttp
// */
//public class OkhttpUtil {
//
//  private OkHttpClient client = new OkHttpClient();
//
//  private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//
//  public String sendGetRequest(String url) {
//    Request request = new Request.Builder().url(url).build();
//    Response response = null;
//    try {
//      response = client.newCall(request).execute();
//      if (response.isSuccessful()) {
//        return response.body().string();
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return "";
//  }
//
//  public int sendDelRequest(String url) {
//    Request request = new Request.Builder().url(url).delete().build();
//    return sendOperateRequest(request);
//  }
//
//  public int sendPostRequest(String url, String json) {
////        RequestBody formBody = new FormEncodingBuilder()
////                .add("platform", "android")
////                .add("name", "bug")
////                .add("subject", "XXXXXXXXXXXXXXX")
////                .build();
//    RequestBody body = RequestBody.create(JSON, json);
//    Request request = new Request.Builder().url(url).post(body).build();
//    return sendOperateRequest(request);
//  }
//
//  public int sendPutRequest(String url, String json) {
//    RequestBody body = RequestBody.create(JSON, json);
//    Request request = new Request.Builder().url(url).put(body).build();
//    return sendOperateRequest(request);
//  }
//
//  private int sendOperateRequest(Request request) {
//    Response response = null;
//    try {
//      response = client.newCall(request).execute();
//      if (response.isSuccessful()) {
//        return 0;
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return -1;
//  }
//}