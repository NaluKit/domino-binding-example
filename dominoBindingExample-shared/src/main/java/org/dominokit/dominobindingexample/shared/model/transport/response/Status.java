package org.dominokit.dominobindingexample.shared.model.transport.response;

import org.dominokit.dominobindingexample.shared.model.AbstractDto;
import org.dominokit.dominobindingexample.shared.model.Message;
import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;

@JSONMapper
public class Status
    extends AbstractDto {

  public static final String OK                     = "200";
  public static final String NOT_FOUND              = "404";
  public static final String CONFLICT               = "409";
  public static final String TECHNICAL_SERVER_ERROR = "500";
  public static final String NOT_AUTHORIZED         = "511";
  public static final String BUSINESS_ERROR         = "900";

  /* Returncode des Calls */           String        returnCode;
  /* Liste der fachlichen Meldungen */ List<Message> message;

  public Status() {
    this(null);
  }

  public Status(String returnCode) {
    this.returnCode = returnCode;

    this.message = new ArrayList<>();
  }

  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  public List<Message> getMessage() {
    return message;
  }

}
