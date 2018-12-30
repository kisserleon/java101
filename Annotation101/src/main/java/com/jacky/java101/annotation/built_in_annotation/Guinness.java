package com.jacky.java101.annotation.built_in_annotation;

public class Guinness extends Beer {
  @SuppressWarnings("deprecation")
  @Override
  public String name() {
    return "Guinness";
  }

  @Override
  public String getName() {
    return "Guinness";
  }
}
