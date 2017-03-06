package com.silicon.raja.heterogenousrecylcerview.model;

/**
 * Created by rajamohamed on 06/03/17.
 */
public class ItemModel {

  private String name;
  private String url;
  private String description;

  public ItemModel(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
