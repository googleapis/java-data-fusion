/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datafusion.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datafusion.v1.stub.DataFusionStub;
import com.google.cloud.datafusion.v1.stub.DataFusionStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for creating and managing Data Fusion instances. Data Fusion enables
 * ETL developers to build code-free, data integration pipelines via a point-and-click UI.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
 *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
 *   Instance response = dataFusionClient.getInstance(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataFusionClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of DataFusionSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * DataFusionSettings dataFusionSettings =
 *     DataFusionSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataFusionClient dataFusionClient = DataFusionClient.create(dataFusionSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * DataFusionSettings dataFusionSettings =
 *     DataFusionSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataFusionClient dataFusionClient = DataFusionClient.create(dataFusionSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataFusionClient implements BackgroundResource {
  private final DataFusionSettings settings;
  private final DataFusionStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of DataFusionClient with default settings. */
  public static final DataFusionClient create() throws IOException {
    return create(DataFusionSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataFusionClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataFusionClient create(DataFusionSettings settings) throws IOException {
    return new DataFusionClient(settings);
  }

  /**
   * Constructs an instance of DataFusionClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DataFusionSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DataFusionClient create(DataFusionStub stub) {
    return new DataFusionClient(stub);
  }

  /**
   * Constructs an instance of DataFusionClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected DataFusionClient(DataFusionSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataFusionStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DataFusionClient(DataFusionStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final DataFusionSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataFusionStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Version element : dataFusionClient.listAvailableVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve instance information in
   *     the format projects/{project}/locations/{location}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAvailableVersionsPagedResponse listAvailableVersions(String parent) {
    ListAvailableVersionsRequest request =
        ListAvailableVersionsRequest.newBuilder().setParent(parent).build();
    return listAvailableVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   for (Version element : dataFusionClient.listAvailableVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAvailableVersionsPagedResponse listAvailableVersions(
      ListAvailableVersionsRequest request) {
    return listAvailableVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   ApiFuture<Version> future =
   *       dataFusionClient.listAvailableVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Version element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable() {
    return stub.listAvailableVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists possible versions for Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListAvailableVersionsRequest request =
   *       ListAvailableVersionsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLatestPatchOnly(true)
   *           .build();
   *   while (true) {
   *     ListAvailableVersionsResponse response =
   *         dataFusionClient.listAvailableVersionsCallable().call(request);
   *     for (Version element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable() {
    return stub.listAvailableVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : dataFusionClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       dataFusionClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Data Fusion instances in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = dataFusionClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getResponsesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = dataFusionClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Instance> future = dataFusionClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String parent = "parent-995424086";
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = dataFusionClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent The instance's project and location in the format
   *     projects/{project}/locations/{location}.
   * @param instance An instance resource.
   * @param instanceId The name of the instance to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   Instance response = dataFusionClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Data Fusion instance in the specified project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Date Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   String name = "name3373707";
   *   dataFusionClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name The instance resource name in the format
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Date Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   dataFusionClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Date Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       dataFusionClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Date Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = dataFusionClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = dataFusionClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance The instance resource that replaces the resource on the server. Currently, Data
   *     Fusion only allows replacing labels, options, and stack driver settings. All other fields
   *     will be ignored.
   * @param updateMask Field mask is used to specify the fields that the update will overwrite in an
   *     instance resource. The fields specified in the update_mask are relative to the resource,
   *     not the full request. A field will be overwritten if it is in the mask. If the user does
   *     not provide a mask, all the supported fields (labels, options, and version currently) will
   *     be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Instance response = dataFusionClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a single Data Fusion instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = dataFusionClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder().setName("name3373707").build();
   *   Instance response = dataFusionClient.restartInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> restartInstanceAsync(
      RestartInstanceRequest request) {
    return restartInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder().setName("name3373707").build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       dataFusionClient.restartInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return stub.restartInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restart a single Data Fusion instance. At the end of an operation instance is fully restarted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataFusionClient dataFusionClient = DataFusionClient.create()) {
   *   RestartInstanceRequest request =
   *       RestartInstanceRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Operation> future = dataFusionClient.restartInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return stub.restartInstanceCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListAvailableVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version,
          ListAvailableVersionsPage, ListAvailableVersionsFixedSizeCollection> {

    public static ApiFuture<ListAvailableVersionsPagedResponse> createAsync(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ApiFuture<ListAvailableVersionsResponse> futureResponse) {
      ApiFuture<ListAvailableVersionsPage> futurePage =
          ListAvailableVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListAvailableVersionsPage, ListAvailableVersionsPagedResponse>() {
            @Override
            public ListAvailableVersionsPagedResponse apply(ListAvailableVersionsPage input) {
              return new ListAvailableVersionsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListAvailableVersionsPagedResponse(ListAvailableVersionsPage page) {
      super(page, ListAvailableVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAvailableVersionsPage
      extends AbstractPage<
          ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version,
          ListAvailableVersionsPage> {

    private ListAvailableVersionsPage(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ListAvailableVersionsResponse response) {
      super(context, response);
    }

    private static ListAvailableVersionsPage createEmptyPage() {
      return new ListAvailableVersionsPage(null, null);
    }

    @Override
    protected ListAvailableVersionsPage createPage(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ListAvailableVersionsResponse response) {
      return new ListAvailableVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAvailableVersionsPage> createPageAsync(
        PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version> context,
        ApiFuture<ListAvailableVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAvailableVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version,
          ListAvailableVersionsPage, ListAvailableVersionsFixedSizeCollection> {

    private ListAvailableVersionsFixedSizeCollection(
        List<ListAvailableVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAvailableVersionsFixedSizeCollection createEmptyCollection() {
      return new ListAvailableVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAvailableVersionsFixedSizeCollection createCollection(
        List<ListAvailableVersionsPage> pages, int collectionSize) {
      return new ListAvailableVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstancesPage, ListInstancesPagedResponse>() {
            @Override
            public ListInstancesPagedResponse apply(ListInstancesPage input) {
              return new ListInstancesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }
}
