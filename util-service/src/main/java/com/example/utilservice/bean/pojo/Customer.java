package com.example.utilservice.bean.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {
  private Integer id;
  private String name;
  private String gender;
  private String telephone;
}
