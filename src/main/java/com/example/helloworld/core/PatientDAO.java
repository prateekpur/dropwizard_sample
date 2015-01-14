package com.example.helloworld.core;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PatientDAO extends AbstractDAO<Patient> {
  public PatientDAO(SessionFactory factory) {
    super(factory);
  }

  public Patient findById(Integer id) {
    return get(id);
  }

  public int create(Patient person) {
    System.out.println(person);
    return persist(person).getPatientId();
  }

  public List<Patient> findAll() {
    return list(namedQuery("com.example.helloworld.core.Patient.findAll"));
  }
}