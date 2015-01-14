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
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
  private final PatientDAO dao;

    public HelloWorldResource(String template, String defaultName, PatientDAO dao) {
        this.template = template;
        this.defaultName = defaultName;
      this.dao = dao;
      this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @UnitOfWork
    public Patient sayHello(@QueryParam("name") String name) {
//        final String value = String.format(template, name.or(defaultName));
//        return new Saying(counter.incrementAndGet(), value);
      System.out.println(" =================== Name : " + name);
      int id = Integer.parseInt(String.valueOf(name));
      System.out.println(" __________________________  Name : " + id + " : " + name);
      Patient p = dao.findById(id);
      return p;
    }
}