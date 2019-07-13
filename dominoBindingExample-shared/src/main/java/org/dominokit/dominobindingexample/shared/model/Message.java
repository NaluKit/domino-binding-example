package org.dominokit.dominobindingexample.shared.model;

import org.dominokit.domino.binding.shared.model.IsDominoMessage;
import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@JSONMapper
public class Message
    implements IsDominoMessage {

  /* a generated unique id */
  private String       id;
  //  /* message type */
  //  private Type         type;
  /* id of the message */
  private String       messageId;
  //  /* reference */
  //  private String       reference;
  //  /* Key 1 */
  //  private String       key01;
  //  /* Key 2 */
  //  private String       key02;
  /* text of the message */
  private String       text;
  //  /* Referennz auf MessagePresenter (ueber ID) */
  //  private String       fieldInError;
  /* reference the widgets to mark  in error */
  private List<String> errorSources;
  /* Target - describes hwo to handle this message */
  private Target       target;
  //  /* source */
  //  private Source       source;

  public Message() {
    //    this(Type.ERROR,
    //         "",
    //         "",
    //         Visibility.PERMANENT,
    //         Source.UNDEFINED,
    //         null);
    this.errorSources = new ArrayList<>();
  }

  //  //
  //  public DominoMessage(Type type,
  //                       String messageId,
  //                       String reference,
  //                       String key01,
  //                       String key02,
  //                       String text,
  //                       Visibility visibility,
  //                       Source source,
  //                       String fieldInError) {
  //    super();
  //
  //    this.id = GUID.get();
  //
  //    this.type = type;
  //    this.reference = reference;
  //    this.key01 = key01;
  //    this.key02 = key02;
  //    this.messageId = messageId;
  //    this.text = text;
  //    this.setFieldInError(fieldInError);
  //    this.visibility = visibility;
  //    this.source = source;
  //
  //    this.messageWidgetsWithoutBlurHandling = new ArrayList<>();
  //  }
  //
  //  public DominoMessage(Type type,
  //                       String messageId,
  //                       String text,
  //                       Visibility visibility) {
  //    this(type,
  //         messageId,
  //         null,
  //         null,
  //         null,
  //         text,
  //         visibility,
  //         Source.UNDEFINED,
  //         null);
  //  }
  //
  //  public DominoMessage(Type type,
  //                       String messageId,
  //                       String text,
  //                       Source source,
  //                       Visibility visibility) {
  //    this(type,
  //         messageId,
  //         null,
  //         null,
  //         null,
  //         text,
  //         visibility,
  //         source,
  //         null);
  //  }
  //
  //  public DominoMessage(Type type,
  //                       String messageId,
  //                       String text,
  //                       Visibility visibility,
  //                       String fieldInError) {
  //    this(type,
  //         messageId,
  //         null,
  //         null,
  //         null,
  //         text,
  //         visibility,
  //         Source.UNDEFINED,
  //         fieldInError);
  //  }
  //
  //  public DominoMessage(Type type,
  //                       String messageId,
  //                       String text,
  //                       Visibility visibility,
  //                       Source source,
  //                       String fieldInError) {
  //    this(type,
  //         messageId,
  //         null,
  //         null,
  //         null,
  //         text,
  //         visibility,
  //         source,
  //         fieldInError);
  //  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Target getTarget() {
    return target;
  }

  public void setTarget(Target target) {
    this.target = target;
  }

  public List<String> getErrorSources() {
    return errorSources;
  }

  public void setErrorSources(List<String> errorSources) {
    this.errorSources = errorSources;
  }
  //  public enum Type {
  //    INFO("4"),
  //    WARNING("3"),
  //    ERROR("2"),
  //    FATAL("1");
  //
  //    private String orderNr;
  //
  //    Type(String orderNr) {
  //      this.orderNr = orderNr;
  //    }
  //
  //    public String getOrderNr() {
  //      return orderNr;
  //    }
  //  }

  //  // defines the source of the message creator
  //  public enum Source {
  //    // messages was issued by the client
  //    CLIENT,
  //    // message was issued by the server
  //    SERVER,
  //    // source is undefined ...
  //    UNDEFINED,
  //  }

}
