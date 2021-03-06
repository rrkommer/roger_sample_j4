package com.artefaktur.sample.j4.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.artefaktur.sample.j4.controller.BookController;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@ApplicationPath("/api")
public class SampleResourceConfig extends ResourceConfig
{
  public SampleResourceConfig()
  {
    //    register(LoggingFeature.class);
    //    register(EndpointLoggingListener.class);

    register(JacksonJaxbJsonProvider.class);

    register(BookController.class);

  }
}
