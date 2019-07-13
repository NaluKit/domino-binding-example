package org.dominokit.dominobindingexample.client.ui.application.content.screen02;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.dominobindingexample.shared.model.Message;

import java.util.List;

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
public interface IScreen02Component
    extends IsComponent<IScreen02Component.Controller, HTMLElement> {

  void consumeMessages(List<Message> messages);

  String getErrorMessage();

  String getSelectedField();

  interface Controller
      extends IsComponent.Controller {

    void doSend();

  }

}
