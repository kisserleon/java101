package com.jacky.java101.annotation.built_in_annotation;

public class Beer {
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
