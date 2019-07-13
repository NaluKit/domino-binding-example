package org.dominokit.dominobindingexample.client.ui.application.content.screen01;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import org.dominokit.dominobindingexample.client.DominoBindingExampleContext;
import org.dominokit.dominobindingexample.client.event.StatusChangeEvent;
import org.dominokit.dominobindingexample.client.service.ValidationServiceFactory;
import org.dominokit.dominobindingexample.shared.model.MyModel;
import org.dominokit.dominobindingexample.shared.model.transport.request.ValidationRequest;

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
@Controller(route = "/application/screen01",
            selector = "content",
            componentInterface = IScreen01Component.class,
            component = Screen01Component.class)
public class Screen01Controller
    extends AbstractComponentController<DominoBindingExampleContext, IScreen01Component, HTMLElement>
    implements IScreen01Component.Controller {

  private MyModel model;

  public Screen01Controller() {
  }

  @Override
  public void start() {
    // Here we simulate the creation of a model.
    // In the real world we would do a server call or
    // something else to get the data.
    model = new MyModel("This value is set using the edit method! The value is >>" + "Main" + "<<");
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>Main<<"));
  }

  @Override
  public void doSend() {
    ValidationRequest request = new ValidationRequest(this.component.getSelectedField(),
                                                      this.component.getErrorMessage());
    ValidationServiceFactory.INSTANCE.validate(request)
                                     .onSuccess(response -> this.component.consumeMessages(response.getStatus()
                                                                                                   .getMessage()))
                                     .onFailed(response -> DomGlobal.window.alert("PANIC!"))
                                     .send();
  }

}
