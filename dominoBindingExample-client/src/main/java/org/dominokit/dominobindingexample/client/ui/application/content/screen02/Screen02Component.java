package org.dominokit.dominobindingexample.client.ui.application.content.screen02;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.binding.client.handling.IsMessageDriver;
import org.dominokit.domino.binding.client.handling.IsMessageProvider;
import org.dominokit.domino.binding.client.handling.annotation.HasMessageDriverSupport;
import org.dominokit.domino.binding.client.handling.annotation.MessagePresenter;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.dominobindingexample.client.ui.application.content.screen01.Screen01ComponentMessageDriverImpl;
import org.dominokit.dominobindingexample.shared.model.Message;
import org.jboss.gwt.elemento.core.Elements;

import java.util.List;

/**
 * Copyright (C) 2028 - 2029 Frank Hossfeld <frank.hossfeld@googlemail.com>
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
@HasMessageDriverSupport(clearOnBlur = false)
public class Screen02Component
    extends AbstractComponent<IScreen02Component.Controller, HTMLElement>
    implements IScreen02Component,
               IsMessageProvider {

  @MessagePresenter("field01")
  TextBox tbField01;

  @MessagePresenter("field02")
  TextBox tbField02;

  @MessagePresenter("field03")
  TextBox tbField03;

  @MessagePresenter("field04")
  TextBox tbField04;

  private Select  fieldSelector;
  private TextBox tbErrorMessage;

  private IsMessageDriver<Screen02Component> messageDriver;

  public Screen02Component() {
    super();
  }

  @Override
  public void render() {
    this.tbField01 = TextBox.create("Text Field 01");
    this.tbField02 = TextBox.create("Text Field 02");
    this.tbField03 = TextBox.create("Text Field 03");
    this.tbField04 = TextBox.create("Text Field 04");

    this.fieldSelector = Select.create("Select Text Field")
                               .appendChild(SelectOption.create("nothing",
                                                                "-- please select --"))
                               .appendChild(SelectOption.create("field01",
                                                                "Text Field 01"))
                               .appendChild(SelectOption.create("field02",
                                                                "Text Field 02"))
                               .appendChild(SelectOption.create("field03",
                                                                "Text Field 03"))
                               .appendChild(SelectOption.create("field04",
                                                                "Text Field 04"))
                               .setSearchable(false)
                               .selectAt(0)
                               .styler(style -> style.setMarginTop("20px"));

    this.tbErrorMessage = new TextBox().create("Error Message");

    HTMLDivElement divElemet = Elements.div()
                                       .asElement();

    Card card01 = Card.create("Error Binding Example - ClearOnBlue = false")
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.tbField01)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span6()
                                                       .appendChild(this.tbField02))
                                      .addColumn(Column.span6()
                                                       .appendChild(this.tbField03)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.tbField04)));
    divElemet.appendChild(card01.asElement());

    Card card02 = Card.create("Configurator")
                      .appendChild(Row.create()
                                      .addColumn(Column.span6()
                                                       .appendChild(this.fieldSelector)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.tbErrorMessage)));
    divElemet.appendChild(card02.asElement());

    divElemet.appendChild(Card.create()
                              .appendChild(Row.create()
                                              .appendChild(Column.span10())
                                              .addColumn(Column.span1()
                                                               .appendChild(Button.createPrimary("Clear Message")
                                                                                  .style()
                                                                                  .setMarginRight("20px")
                                                                                  .get()
                                                                                  .addClickListener(e -> this.messageDriver.clearInvalid())))
                                              .addColumn(Column.span1()
                                                               .appendChild(Button.createPrimary("Send Request")
                                                                                  .style()
                                                                                  .setMarginRight("20px")
                                                                                  .get()
                                                                                  .addClickListener(e -> getController().doSend())))
                                              .styler(style -> {
                                                style.setMarginTop("20px");
                                                style.setTextAlign("right");
                                              }))
                              .asElement());

    initElement(divElemet);
  }

  @Override
  public void onAttach() {
    this.messageDriver = new Screen02ComponentMessageDriverImpl();
    this.messageDriver.initialize(this);
    this.messageDriver.register();
  }

  @Override
  public void onDetach() {
    this.messageDriver.deregisterAndDestroy();
  }

  @Override
  public void consumeMessages(List<Message> messages) {
    this.messageDriver.consume(messages);
  }

  @Override
  public String getErrorMessage() {
    return this.tbErrorMessage.getValue();
  }

  @Override
  public String getSelectedField() {
    return (String) this.fieldSelector.getValue();
  }

}
