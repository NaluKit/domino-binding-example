package org.dominokit.dominobindingexample.server.resource;

import org.dominokit.domino.binding.shared.model.IsDominoMessage.Target;
import org.dominokit.dominobindingexample.shared.model.Message;
import org.dominokit.dominobindingexample.shared.model.transport.request.ValidationRequest;
import org.dominokit.dominobindingexample.shared.model.transport.response.Status;
import org.dominokit.dominobindingexample.shared.model.transport.response.ValidationResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/data")
public class ValidationResource {

  @POST
  @Path("/validate")
  @Consumes("application/json")
  //@Produces("application/json")
  public ValidationResponse validate(ValidationRequest request) {
    ValidationResponse response = new ValidationResponse();
    Status status = new Status();
    status.setReturnCode(Status.OK);
    response.setStatus(status);

    Message message = new Message();
    message.setId(String.valueOf(System.currentTimeMillis()));
    message.setMessageId(String.valueOf(System.currentTimeMillis()));
    message.setTarget(Target.FIELD);
    message.setText(request.getErrorMessage());
    message.getErrorSources()
           .add(request.getSelectedField());
    status.getMessage()
          .add(message);

    return response;
  }

}