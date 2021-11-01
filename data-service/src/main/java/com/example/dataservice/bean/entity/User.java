package com.example.dataservice.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private String name;
  @Column(name = "sex")
  private String sex;
  @Column(name = "age")
  @Max(200)
  @Min(1)
  private int age;

  @Column(nullable = false)
  private String password;

  @Column(name = "create_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)

  @Generated(GenerationTime.ALWAYS)
  private Timestamp birth;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
