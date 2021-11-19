package com.example.utilservice.battle.common.instance.jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {
  private String key;
  private String name;
  private String description;
  private InputStream value;
}
