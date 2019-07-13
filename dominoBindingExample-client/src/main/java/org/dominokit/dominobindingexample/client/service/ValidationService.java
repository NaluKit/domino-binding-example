package org.dominokit.dominobindingexample.client.service;

import org.dominokit.domino.rest.shared.request.service.annotations.RequestBody;
import org.dominokit.domino.rest.shared.request.service.annotations.RequestFactory;
import org.dominokit.dominobindingexample.shared.model.transport.request.ValidationRequest;
import org.dominokit.dominobindingexample.shared.model.transport.response.ValidationResponse;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/data")
@RequestFactory
public interface ValidationService {

  @POST
  @Path("/validate")
  ValidationResponse validate(@RequestBody ValidationRequest request);

}
