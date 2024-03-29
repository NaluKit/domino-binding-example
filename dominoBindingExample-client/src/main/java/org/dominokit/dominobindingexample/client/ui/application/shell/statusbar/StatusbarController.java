package org.dominokit.dominobindingexample.client.ui.application.shell.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;
import org.dominokit.dominobindingexample.client.DominoBindingExampleContext;
import org.dominokit.dominobindingexample.client.event.StatusChangeEvent;
import org.gwtproject.event.shared.HandlerRegistration;

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
@Controller(route = "/application/",
            selector = "footer",
            componentInterface = IStatusbarComponent.class,
            component = StatusbarComponent.class)
public class StatusbarController
    extends AbstractComponentController<DominoBindingExampleContext, IStatusbarComponent, HTMLElement>
    implements IStatusbarComponent.Controller {

  private HandlerRegistration registration;

  public StatusbarController() {
  }

  @Override
  public void start() {
    this.registration = this.eventBus.addHandler(StatusChangeEvent.TYPE,
                                                 e -> component.edit(e.getStatus()));
  }

  @Override
  public void stop() {
    this.registration.removeHandler();
  }

}
