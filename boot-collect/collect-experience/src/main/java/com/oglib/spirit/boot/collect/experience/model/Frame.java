// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: frame.proto

package com.oglib.spirit.boot.collect.experience.model;

/**
 * Protobuf type {@code Frame}
 */
public  final class Frame extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Frame)
    FrameOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Frame.newBuilder() to construct.
  private Frame(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Frame() {
    messageName_ = "";
    data_ = com.google.protobuf.ByteString.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Frame();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Frame(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();

            messageName_ = s;
            break;
          }
          case 18: {

            data_ = input.readBytes();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_Frame_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_Frame_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.oglib.spirit.boot.collect.experience.model.Frame.class, com.oglib.spirit.boot.collect.experience.model.Frame.Builder.class);
  }

  public static final int MESSAGENAME_FIELD_NUMBER = 1;
  private volatile Object messageName_;
  /**
   * <code>string messageName = 1;</code>
   * @return The messageName.
   */
  public String getMessageName() {
    Object ref = messageName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      messageName_ = s;
      return s;
    }
  }
  /**
   * <code>string messageName = 1;</code>
   * @return The bytes for messageName.
   */
  public com.google.protobuf.ByteString
      getMessageNameBytes() {
    Object ref = messageName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      messageName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString data_;
  /**
   * <code>bytes data = 2;</code>
   * @return The data.
   */
  public com.google.protobuf.ByteString getData() {
    return data_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getMessageNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, messageName_);
    }
    if (!data_.isEmpty()) {
      output.writeBytes(2, data_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMessageNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, messageName_);
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, data_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.oglib.spirit.boot.collect.experience.model.Frame)) {
      return super.equals(obj);
    }
    com.oglib.spirit.boot.collect.experience.model.Frame other = (com.oglib.spirit.boot.collect.experience.model.Frame) obj;

    if (!getMessageName()
        .equals(other.getMessageName())) return false;
    if (!getData()
        .equals(other.getData())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MESSAGENAME_FIELD_NUMBER;
    hash = (53 * hash) + getMessageName().hashCode();
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.Frame parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.oglib.spirit.boot.collect.experience.model.Frame prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Frame}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Frame)
      com.oglib.spirit.boot.collect.experience.model.FrameOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_Frame_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_Frame_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.oglib.spirit.boot.collect.experience.model.Frame.class, com.oglib.spirit.boot.collect.experience.model.Frame.Builder.class);
    }

    // Construct using com.oglib.spirit.boot.collect.experience.model.Frame.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      messageName_ = "";

      data_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_Frame_descriptor;
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.Frame getDefaultInstanceForType() {
      return com.oglib.spirit.boot.collect.experience.model.Frame.getDefaultInstance();
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.Frame build() {
      com.oglib.spirit.boot.collect.experience.model.Frame result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.Frame buildPartial() {
      com.oglib.spirit.boot.collect.experience.model.Frame result = new com.oglib.spirit.boot.collect.experience.model.Frame(this);
      result.messageName_ = messageName_;
      result.data_ = data_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.oglib.spirit.boot.collect.experience.model.Frame) {
        return mergeFrom((com.oglib.spirit.boot.collect.experience.model.Frame)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.oglib.spirit.boot.collect.experience.model.Frame other) {
      if (other == com.oglib.spirit.boot.collect.experience.model.Frame.getDefaultInstance()) return this;
      if (!other.getMessageName().isEmpty()) {
        messageName_ = other.messageName_;
        onChanged();
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.oglib.spirit.boot.collect.experience.model.Frame parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.oglib.spirit.boot.collect.experience.model.Frame) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object messageName_ = "";
    /**
     * <code>string messageName = 1;</code>
     * @return The messageName.
     */
    public String getMessageName() {
      Object ref = messageName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        messageName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string messageName = 1;</code>
     * @return The bytes for messageName.
     */
    public com.google.protobuf.ByteString
        getMessageNameBytes() {
      Object ref = messageName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        messageName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string messageName = 1;</code>
     * @param value The messageName to set.
     * @return This builder for chaining.
     */
    public Builder setMessageName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      messageName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string messageName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageName() {
      
      messageName_ = getDefaultInstance().getMessageName();
      onChanged();
      return this;
    }
    /**
     * <code>string messageName = 1;</code>
     * @param value The bytes for messageName to set.
     * @return This builder for chaining.
     */
    public Builder setMessageNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      messageName_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes data = 2;</code>
     * @return The data.
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <code>bytes data = 2;</code>
     * @param value The data to set.
     * @return This builder for chaining.
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes data = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearData() {
      
      data_ = getDefaultInstance().getData();
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Frame)
  }

  // @@protoc_insertion_point(class_scope:Frame)
  private static final com.oglib.spirit.boot.collect.experience.model.Frame DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.oglib.spirit.boot.collect.experience.model.Frame();
  }

  public static com.oglib.spirit.boot.collect.experience.model.Frame getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Frame>
      PARSER = new com.google.protobuf.AbstractParser<Frame>() {
    @Override
    public Frame parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Frame(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Frame> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Frame> getParserForType() {
    return PARSER;
  }

  @Override
  public com.oglib.spirit.boot.collect.experience.model.Frame getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

