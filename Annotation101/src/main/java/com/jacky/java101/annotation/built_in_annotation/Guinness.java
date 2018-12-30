package com.jacky.java101.annotation.built_in_annotation;

class Beer {
  /**
   * @deprecated use of name
   * is discouraged, use
   * getName instead.
   */
  @Deprecated
  public String name() { return "Beer"; }
  public String getName() {
    return "Beer";
  }
}


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
