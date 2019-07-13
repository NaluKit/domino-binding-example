package org.dominokit.dominobindingexample.shared.model.transport.request;

import org.dominokit.jacksonapt.annotation.JSONMapper;

@JSONMapper
public class ValidationRequest
    extends AbstractRequest {

  private String selectedField;
  private String errorMessage;

  public ValidationRequest() {
    this(null,
         null);
  }

  public ValidationRequest(String selectedField,
                           String errorMessage) {
    super();
    this.selectedField = selectedField;
    this.errorMessage = errorMessage;
  }

  public String getSelectedField() {
    return selectedField;
  }

  public void setSelectedField(String selectedField) {
    this.selectedField = selectedField;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}
