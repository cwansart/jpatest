package de.cwansart.jpatest.application;

import de.cwansart.jpatest.domain.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  private UserService service;

  @GET
  public Response getAll() {
    return Response.ok(service.getAll()).build();
  }
}
