package com.silicon.raja.heterogenousrecylcerview.model;

import java.util.ArrayList;

/**
 * Created by rajamohamed on 06/03/17.
 */

public class SectionModel {

  private String headerTitle;
  private ArrayList<ItemModel> allItemsInSection;

  public String getHeaderTitle() {
    return headerTitle;
  }

  public void setHeaderTitle(String headerTitle) {
    this.headerTitle = headerTitle;
  }

  public ArrayList<ItemModel> getAllItemsInSection() {
    return allItemsInSection;
  }

  public void setAllItemsInSection(ArrayList<ItemModel> allItemsInSection) {
    this.allItemsInSection = allItemsInSection;
  }
}
