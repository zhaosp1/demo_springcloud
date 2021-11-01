package com.example.dataservice.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 20)
  private String name;
  private String gender;
  private String telephone;
}