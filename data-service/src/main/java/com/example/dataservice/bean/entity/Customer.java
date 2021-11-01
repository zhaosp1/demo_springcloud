package com.example.dataservice.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: zhaosp1
 * @description:
 * @version: 1.0
 * @createDate: 2021/09/24 0:04
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String gender;
    private String telephone;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}