package org.dominokit.dominobindingexample.shared.model;

public abstract class AbstractDto {

  private String uuid;

  public AbstractDto() {
    super();
    this.uuid = UUID.get();
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

}
