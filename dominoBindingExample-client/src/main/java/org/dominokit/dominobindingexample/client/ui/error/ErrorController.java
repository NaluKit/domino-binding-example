package org.dominokit.dominobindingexample.client.ui.error;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import org.dominokit.dominobindingexample.client.DominoBindingExampleContext;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Controller(route = "/error/error",
            selector = "content",
            componentInterface = IErrorComponent.class,
            component = ErrorComponent.class)
public class ErrorController
    extends AbstractComponentController<DominoBindingExampleContext, IErrorComponent, HTMLElement>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void start() {
    // Get the error message from the router and set it.
    this.component.setErrorMessage(this.router.getNaluErrorMessage()
                                              .getErrorMessage());
  }

  @Override
  public void doRouteHome() {
    this.router.route("/application/screen01");
  }

}
