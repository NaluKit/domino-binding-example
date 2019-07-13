package org.dominokit.dominobindingexample.client;

import com.github.nalukit.nalu.plugin.elemental2.client.NaluPluginElemental2;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.rest.DominoRestConfig;

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
public class DominoBindingExample
    implements EntryPoint {

  public void onModuleLoad() {
    String serviceRoot = createServicesRoot();
    DominoRestConfig.initDefaults();
    DominoRestConfig.getInstance()
                    .setDefaultServiceRoot(serviceRoot);

    DominoBindingExampleApplication application = new DominoBindingExampleApplicationImpl();
    application.run(new NaluPluginElemental2());
  }

  private String createServicesRoot() {
    StringBuffer sb = new StringBuffer();
    sb.append(DomGlobal.location.getOrigin());
    if (GWT.isProdMode()) {
      sb.append("/dominoBindingExample");
    }
    sb.append("/service");
    return sb.toString();
  }

}
