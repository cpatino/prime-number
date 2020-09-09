package com.developer.prime.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prime {

  @Id
  private int number;
  
  public Prime() {
    super();
  }
  
  public Prime(int number) {
    this.number = number;
  }
  
  public int getNumber() {
    return number;
  }
}
