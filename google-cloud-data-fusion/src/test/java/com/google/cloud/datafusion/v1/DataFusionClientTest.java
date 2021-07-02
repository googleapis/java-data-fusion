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

import static com.google.cloud.datafusion.v1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1.DataFusionClient.ListInstancesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataFusionClientTest {
  private static MockDataFusion mockDataFusion;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataFusionClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataFusion = new MockDataFusion();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDataFusion));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    DataFusionSettings settings =
        DataFusionSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataFusionClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listAvailableVersionsTest() throws Exception {
    Version responsesElement = Version.newBuilder().build();
    ListAvailableVersionsResponse expectedResponse =
        ListAvailableVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAvailableVersions(Arrays.asList(responsesElement))
            .build();
    mockDataFusion.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAvailableVersionsPagedResponse pagedListResponse = client.listAvailableVersions(parent);

    List<Version> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAvailableVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAvailableVersionsRequest actualRequest =
        ((ListAvailableVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAvailableVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAvailableVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listInstancesTest() throws Exception {
    Instance responsesElement = Instance.newBuilder().build();
    ListInstancesResponse expectedResponse =
        ListInstancesResponse.newBuilder()
            .setNextPageToken("")
            .addAllInstances(Arrays.asList(responsesElement))
            .build();
    mockDataFusion.addResponse(expectedResponse);

    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent("parent-995424086")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setFilter("filter-1274492040")
            .setOrderBy("orderBy-1207110587")
            .build();

    ListInstancesPagedResponse pagedListResponse = client.listInstances(request);

    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getInstancesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInstancesRequest actualRequest = ((ListInstancesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getOrderBy(), actualRequest.getOrderBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listInstancesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      ListInstancesRequest request =
          ListInstancesRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      client.listInstances(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .build();
    mockDataFusion.addResponse(expectedResponse);

    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.getInstance(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetInstanceRequest actualRequest = ((GetInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      GetInstanceRequest request = GetInstanceRequest.newBuilder().setName("name3373707").build();
      client.getInstance(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataFusion.addResponse(resultOperation);

    String parent = "parent-995424086";
    Instance instance = Instance.newBuilder().build();
    String instanceId = "instanceId902024336";

    Instance actualResponse = client.createInstanceAsync(parent, instance, instanceId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInstanceRequest actualRequest = ((CreateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(instanceId, actualRequest.getInstanceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      String parent = "parent-995424086";
      Instance instance = Instance.newBuilder().build();
      String instanceId = "instanceId902024336";
      client.createInstanceAsync(parent, instance, instanceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataFusion.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteInstanceAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteInstanceRequest actualRequest = ((DeleteInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      String name = "name3373707";
      client.deleteInstanceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataFusion.addResponse(resultOperation);

    Instance instance = Instance.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Instance actualResponse = client.updateInstanceAsync(instance, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateInstanceRequest actualRequest = ((UpdateInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(instance, actualRequest.getInstance());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      Instance instance = Instance.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateInstanceAsync(instance, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void restartInstanceTest() throws Exception {
    Instance expectedResponse =
        Instance.newBuilder()
            .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
            .setDescription("description-1724546052")
            .setEnableStackdriverLogging(true)
            .setEnableStackdriverMonitoring(true)
            .setPrivateInstance(true)
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllOptions(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStateMessage("stateMessage1128185398")
            .setServiceEndpoint("serviceEndpoint-1323187350")
            .setZone("zone3744684")
            .setVersion("version351608024")
            .setServiceAccount("serviceAccount1079137720")
            .setDisplayName("displayName1714148973")
            .addAllAvailableVersion(new ArrayList<Version>())
            .setApiEndpoint("apiEndpoint-2038677041")
            .setGcsBucket("gcsBucket239654881")
            .addAllAccelerators(new ArrayList<Accelerator>())
            .setP4ServiceAccount("p4ServiceAccount-184825700")
            .setTenantProjectId("tenantProjectId674318474")
            .setDataprocServiceAccount("dataprocServiceAccount-1287630888")
            .setEnableRbac(true)
            .setCryptoKeyConfig(CryptoKeyConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("restartInstanceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataFusion.addResponse(resultOperation);

    RestartInstanceRequest request =
        RestartInstanceRequest.newBuilder().setName("name3373707").build();

    Instance actualResponse = client.restartInstanceAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataFusion.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RestartInstanceRequest actualRequest = ((RestartInstanceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void restartInstanceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataFusion.addException(exception);

    try {
      RestartInstanceRequest request =
          RestartInstanceRequest.newBuilder().setName("name3373707").build();
      client.restartInstanceAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
