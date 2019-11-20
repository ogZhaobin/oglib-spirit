// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: frame.proto

package com.oglib.spirit.boot.collect.experience.model;

/**
 * Protobuf type {@code OrgEntity}
 */
public  final class OrgEntity extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OrgEntity)
    OrgEntityOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrgEntity.newBuilder() to construct.
  private OrgEntity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrgEntity() {
    orgName_ = "";
    orgNo_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new OrgEntity();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OrgEntity(
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

            orgName_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            orgNo_ = s;
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
    return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_OrgEntity_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_OrgEntity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.oglib.spirit.boot.collect.experience.model.OrgEntity.class, com.oglib.spirit.boot.collect.experience.model.OrgEntity.Builder.class);
  }

  public static final int ORGNAME_FIELD_NUMBER = 1;
  private volatile Object orgName_;
  /**
   * <code>string orgName = 1;</code>
   * @return The orgName.
   */
  public String getOrgName() {
    Object ref = orgName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      orgName_ = s;
      return s;
    }
  }
  /**
   * <code>string orgName = 1;</code>
   * @return The bytes for orgName.
   */
  public com.google.protobuf.ByteString
      getOrgNameBytes() {
    Object ref = orgName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      orgName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ORGNO_FIELD_NUMBER = 2;
  private volatile Object orgNo_;
  /**
   * <code>string orgNo = 2;</code>
   * @return The orgNo.
   */
  public String getOrgNo() {
    Object ref = orgNo_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      orgNo_ = s;
      return s;
    }
  }
  /**
   * <code>string orgNo = 2;</code>
   * @return The bytes for orgNo.
   */
  public com.google.protobuf.ByteString
      getOrgNoBytes() {
    Object ref = orgNo_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      orgNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getOrgNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, orgName_);
    }
    if (!getOrgNoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, orgNo_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getOrgNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, orgName_);
    }
    if (!getOrgNoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, orgNo_);
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
    if (!(obj instanceof com.oglib.spirit.boot.collect.experience.model.OrgEntity)) {
      return super.equals(obj);
    }
    com.oglib.spirit.boot.collect.experience.model.OrgEntity other = (com.oglib.spirit.boot.collect.experience.model.OrgEntity) obj;

    if (!getOrgName()
        .equals(other.getOrgName())) return false;
    if (!getOrgNo()
        .equals(other.getOrgNo())) return false;
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
    hash = (37 * hash) + ORGNAME_FIELD_NUMBER;
    hash = (53 * hash) + getOrgName().hashCode();
    hash = (37 * hash) + ORGNO_FIELD_NUMBER;
    hash = (53 * hash) + getOrgNo().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity parseFrom(
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
  public static Builder newBuilder(com.oglib.spirit.boot.collect.experience.model.OrgEntity prototype) {
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
   * Protobuf type {@code OrgEntity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OrgEntity)
      com.oglib.spirit.boot.collect.experience.model.OrgEntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_OrgEntity_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_OrgEntity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.oglib.spirit.boot.collect.experience.model.OrgEntity.class, com.oglib.spirit.boot.collect.experience.model.OrgEntity.Builder.class);
    }

    // Construct using com.oglib.spirit.boot.collect.experience.model.OrgEntity.newBuilder()
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
      orgName_ = "";

      orgNo_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.oglib.spirit.boot.collect.experience.model.FrameOuterClass.internal_static_OrgEntity_descriptor;
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.OrgEntity getDefaultInstanceForType() {
      return com.oglib.spirit.boot.collect.experience.model.OrgEntity.getDefaultInstance();
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.OrgEntity build() {
      com.oglib.spirit.boot.collect.experience.model.OrgEntity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public com.oglib.spirit.boot.collect.experience.model.OrgEntity buildPartial() {
      com.oglib.spirit.boot.collect.experience.model.OrgEntity result = new com.oglib.spirit.boot.collect.experience.model.OrgEntity(this);
      result.orgName_ = orgName_;
      result.orgNo_ = orgNo_;
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
      if (other instanceof com.oglib.spirit.boot.collect.experience.model.OrgEntity) {
        return mergeFrom((com.oglib.spirit.boot.collect.experience.model.OrgEntity)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.oglib.spirit.boot.collect.experience.model.OrgEntity other) {
      if (other == com.oglib.spirit.boot.collect.experience.model.OrgEntity.getDefaultInstance()) return this;
      if (!other.getOrgName().isEmpty()) {
        orgName_ = other.orgName_;
        onChanged();
      }
      if (!other.getOrgNo().isEmpty()) {
        orgNo_ = other.orgNo_;
        onChanged();
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
      com.oglib.spirit.boot.collect.experience.model.OrgEntity parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.oglib.spirit.boot.collect.experience.model.OrgEntity) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object orgName_ = "";
    /**
     * <code>string orgName = 1;</code>
     * @return The orgName.
     */
    public String getOrgName() {
      Object ref = orgName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        orgName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string orgName = 1;</code>
     * @return The bytes for orgName.
     */
    public com.google.protobuf.ByteString
        getOrgNameBytes() {
      Object ref = orgName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        orgName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string orgName = 1;</code>
     * @param value The orgName to set.
     * @return This builder for chaining.
     */
    public Builder setOrgName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      orgName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string orgName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOrgName() {
      
      orgName_ = getDefaultInstance().getOrgName();
      onChanged();
      return this;
    }
    /**
     * <code>string orgName = 1;</code>
     * @param value The bytes for orgName to set.
     * @return This builder for chaining.
     */
    public Builder setOrgNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      orgName_ = value;
      onChanged();
      return this;
    }

    private Object orgNo_ = "";
    /**
     * <code>string orgNo = 2;</code>
     * @return The orgNo.
     */
    public String getOrgNo() {
      Object ref = orgNo_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        orgNo_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string orgNo = 2;</code>
     * @return The bytes for orgNo.
     */
    public com.google.protobuf.ByteString
        getOrgNoBytes() {
      Object ref = orgNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        orgNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string orgNo = 2;</code>
     * @param value The orgNo to set.
     * @return This builder for chaining.
     */
    public Builder setOrgNo(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      orgNo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string orgNo = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearOrgNo() {
      
      orgNo_ = getDefaultInstance().getOrgNo();
      onChanged();
      return this;
    }
    /**
     * <code>string orgNo = 2;</code>
     * @param value The bytes for orgNo to set.
     * @return This builder for chaining.
     */
    public Builder setOrgNoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      orgNo_ = value;
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


    // @@protoc_insertion_point(builder_scope:OrgEntity)
  }

  // @@protoc_insertion_point(class_scope:OrgEntity)
  private static final com.oglib.spirit.boot.collect.experience.model.OrgEntity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.oglib.spirit.boot.collect.experience.model.OrgEntity();
  }

  public static com.oglib.spirit.boot.collect.experience.model.OrgEntity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrgEntity>
      PARSER = new com.google.protobuf.AbstractParser<OrgEntity>() {
    @Override
    public OrgEntity parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OrgEntity(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OrgEntity> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<OrgEntity> getParserForType() {
    return PARSER;
  }

  @Override
  public com.oglib.spirit.boot.collect.experience.model.OrgEntity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

