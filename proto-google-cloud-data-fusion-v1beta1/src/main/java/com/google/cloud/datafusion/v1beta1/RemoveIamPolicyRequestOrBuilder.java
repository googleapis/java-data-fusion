/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/datafusion/v1beta1/v1beta1.proto

package com.google.cloud.datafusion.v1beta1;

public interface RemoveIamPolicyRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.datafusion.v1beta1.RemoveIamPolicyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The resource on which IAM policy to be removed is attached to.
   * </pre>
   *
   * <code>string resource = 1;</code>
   *
   * @return The resource.
   */
  java.lang.String getResource();
  /**
   *
   *
   * <pre>
   * The resource on which IAM policy to be removed is attached to.
   * </pre>
   *
   * <code>string resource = 1;</code>
   *
   * @return The bytes for resource.
   */
  com.google.protobuf.ByteString getResourceBytes();
}