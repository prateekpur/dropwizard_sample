package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient implements java.io.Serializable {

  private int patientId;
  private String patientName;
  private String address;

  public Patient() {
  }

  public Patient(int patientId, String patientName, String address) {
      this.patientId = patientId;
      this.patientName = patientName;
      this.address = address;
  }

  @Id
  @Column(name = "PATIENTID", unique = true, nullable = false, precision = 5, scale = 0)
  public int getPatientId() {
    return this.patientId;
  }

  public void setPatientId(int patientId) {
    this.patientId = patientId;
  }

  @Column(name = "PATIENTNAME", length = 20)
  public String getPatientName() {
    return this.patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  @Column(name = "ADDRESS", length = 20)
  public String getAddress()  {
    return address;
  }

  public void setAddress(String address)  {
    this.address = address;
  }

  public String toString()  {
    StringBuilder bld = new StringBuilder("ID : ");
    bld.append(patientId);
    bld.append("  NAME  : ");
    bld.append(patientName);
    bld.append("  ADDRESS  : ");
    bld.append(address);
    return bld.toString();
  }
}