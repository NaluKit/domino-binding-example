package org.dominokit.dominobindingexample.shared.model.transport.response;

import org.dominokit.dominobindingexample.shared.model.AbstractDto;

class AbstractResponse
    extends AbstractDto {

  AbstractResponse() {
  }

  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

}
