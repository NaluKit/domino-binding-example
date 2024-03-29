package org.dominokit.dominobindingexample.client.ui.application.shell.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

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
public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, HTMLElement>
    implements INavigationComponent {

  public NavigationComponent() {
    super();
  }

  @Override
  public void render() {
    TreeItem treeItem01 = TreeItem.create("Screen01",
                                          Icons.ALL.list())
                                  .addClickListener(e -> getController().doNavigateTo("screen01"));
    TreeItem treeItem02 = TreeItem.create("Screen02",
                                          Icons.ALL.list())
                                  .addClickListener(e -> getController().doNavigateTo("screen02"));
    Tree tree = Tree.create("Navigation");
    tree.appendChild(treeItem01)
        .appendChild(treeItem02);
    initElement(tree.asElement());
  }

}
