package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.core.Patient;
import com.example.helloworld.core.PatientDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/create")
@Produces(MediaType.APPLICATION_JSON)
public class PatientCreateResource {
  private final PatientDAO dao;

  public PatientCreateResource(PatientDAO dao)  {
    this.dao = dao;
  }

  @GET
  @Timed
  @UnitOfWork
  public int createPatient(@QueryParam("name") String name, @QueryParam("id") String id) {
    return dao.create(new Patient(name, name));
  }
}
