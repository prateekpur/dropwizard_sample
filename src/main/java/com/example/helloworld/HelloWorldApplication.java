package com.example.helloworld;

import com.example.helloworld.core.Patient;
import com.example.helloworld.core.PatientDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.health.TemplateHealthCheck;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
  private final HibernateBundle<HelloWorldConfiguration> hibernate = new HibernateBundle<HelloWorldConfiguration>(Patient.class) {
    @Override
    public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
      return configuration.getDataSourceFactory();
    }
  };

  public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
      bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
      final PatientDAO dao = new PatientDAO(hibernate.getSessionFactory());
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                dao);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
      environment.jersey().register(resource);
    }
}
