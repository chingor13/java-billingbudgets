/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.billing.budgets.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.budgets.v1beta1.stub.BudgetServiceStub;
import com.google.cloud.billing.budgets.v1beta1.stub.BudgetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: BudgetService stores Cloud Billing budgets, which define a budget plan and
 * rules to execute as we track spend against that plan.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
 *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
 *   Budget budget = Budget.newBuilder().build();
 *   CreateBudgetRequest request = CreateBudgetRequest.newBuilder()
 *     .setParent(parent.toString())
 *     .setBudget(budget)
 *     .build();
 *   Budget response = budgetServiceClient.createBudget(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the budgetServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of BudgetServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * BudgetServiceSettings budgetServiceSettings =
 *     BudgetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BudgetServiceClient budgetServiceClient =
 *     BudgetServiceClient.create(budgetServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * BudgetServiceSettings budgetServiceSettings =
 *     BudgetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BudgetServiceClient budgetServiceClient =
 *     BudgetServiceClient.create(budgetServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BudgetServiceClient implements BackgroundResource {
  private final BudgetServiceSettings settings;
  private final BudgetServiceStub stub;

  /** Constructs an instance of BudgetServiceClient with default settings. */
  public static final BudgetServiceClient create() throws IOException {
    return create(BudgetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BudgetServiceClient create(BudgetServiceSettings settings)
      throws IOException {
    return new BudgetServiceClient(settings);
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use BudgetServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final BudgetServiceClient create(BudgetServiceStub stub) {
    return new BudgetServiceClient(stub);
  }

  /**
   * Constructs an instance of BudgetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BudgetServiceClient(BudgetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BudgetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected BudgetServiceClient(BudgetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BudgetServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BudgetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new budget if none exists. There is a limit of 1,000 budgets per billing account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   Budget budget = Budget.newBuilder().build();
   *   CreateBudgetRequest request = CreateBudgetRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setBudget(budget)
   *     .build();
   *   Budget response = budgetServiceClient.createBudget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget createBudget(CreateBudgetRequest request) {
    return createBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a new budget if none exists. There is a limit of 1,000 budgets per billing account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   Budget budget = Budget.newBuilder().build();
   *   CreateBudgetRequest request = CreateBudgetRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setBudget(budget)
   *     .build();
   *   ApiFuture&lt;Budget&gt; future = budgetServiceClient.createBudgetCallable().futureCall(request);
   *   // Do something
   *   Budget response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateBudgetRequest, Budget> createBudgetCallable() {
    return stub.createBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a budget and returns the updated budget.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   Budget budget = Budget.newBuilder().build();
   *   UpdateBudgetRequest request = UpdateBudgetRequest.newBuilder()
   *     .setBudget(budget)
   *     .build();
   *   Budget response = budgetServiceClient.updateBudget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget updateBudget(UpdateBudgetRequest request) {
    return updateBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a budget and returns the updated budget.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   Budget budget = Budget.newBuilder().build();
   *   UpdateBudgetRequest request = UpdateBudgetRequest.newBuilder()
   *     .setBudget(budget)
   *     .build();
   *   ApiFuture&lt;Budget&gt; future = budgetServiceClient.updateBudgetCallable().futureCall(request);
   *   // Do something
   *   Budget response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateBudgetRequest, Budget> updateBudgetCallable() {
    return stub.updateBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a budget.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   GetBudgetRequest request = GetBudgetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Budget response = budgetServiceClient.getBudget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Budget getBudget(GetBudgetRequest request) {
    return getBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a budget.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   GetBudgetRequest request = GetBudgetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Budget&gt; future = budgetServiceClient.getBudgetCallable().futureCall(request);
   *   // Do something
   *   Budget response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetBudgetRequest, Budget> getBudgetCallable() {
    return stub.getBudgetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the budgets for a billing account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   ListBudgetsRequest request = ListBudgetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Budget element : budgetServiceClient.listBudgets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBudgetsPagedResponse listBudgets(ListBudgetsRequest request) {
    return listBudgetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the budgets for a billing account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   ListBudgetsRequest request = ListBudgetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListBudgetsPagedResponse&gt; future = budgetServiceClient.listBudgetsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Budget element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListBudgetsRequest, ListBudgetsPagedResponse>
      listBudgetsPagedCallable() {
    return stub.listBudgetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the budgets for a billing account.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   ListBudgetsRequest request = ListBudgetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListBudgetsResponse response = budgetServiceClient.listBudgetsCallable().call(request);
   *     for (Budget element : response.getBudgetsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<ListBudgetsRequest, ListBudgetsResponse> listBudgetsCallable() {
    return stub.listBudgetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   DeleteBudgetRequest request = DeleteBudgetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   budgetServiceClient.deleteBudget(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBudget(DeleteBudgetRequest request) {
    deleteBudgetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a budget. Returns successfully if already deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (BudgetServiceClient budgetServiceClient = BudgetServiceClient.create()) {
   *   BudgetName name = BudgetName.of("[BILLING_ACCOUNT]", "[BUDGET]");
   *   DeleteBudgetRequest request = DeleteBudgetRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = budgetServiceClient.deleteBudgetCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteBudgetRequest, Empty> deleteBudgetCallable() {
    return stub.deleteBudgetCallable();
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

  public static class ListBudgetsPagedResponse
      extends AbstractPagedListResponse<
          ListBudgetsRequest,
          ListBudgetsResponse,
          Budget,
          ListBudgetsPage,
          ListBudgetsFixedSizeCollection> {

    public static ApiFuture<ListBudgetsPagedResponse> createAsync(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ApiFuture<ListBudgetsResponse> futureResponse) {
      ApiFuture<ListBudgetsPage> futurePage =
          ListBudgetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListBudgetsPage, ListBudgetsPagedResponse>() {
            @Override
            public ListBudgetsPagedResponse apply(ListBudgetsPage input) {
              return new ListBudgetsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListBudgetsPagedResponse(ListBudgetsPage page) {
      super(page, ListBudgetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBudgetsPage
      extends AbstractPage<ListBudgetsRequest, ListBudgetsResponse, Budget, ListBudgetsPage> {

    private ListBudgetsPage(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ListBudgetsResponse response) {
      super(context, response);
    }

    private static ListBudgetsPage createEmptyPage() {
      return new ListBudgetsPage(null, null);
    }

    @Override
    protected ListBudgetsPage createPage(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ListBudgetsResponse response) {
      return new ListBudgetsPage(context, response);
    }

    @Override
    public ApiFuture<ListBudgetsPage> createPageAsync(
        PageContext<ListBudgetsRequest, ListBudgetsResponse, Budget> context,
        ApiFuture<ListBudgetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBudgetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBudgetsRequest,
          ListBudgetsResponse,
          Budget,
          ListBudgetsPage,
          ListBudgetsFixedSizeCollection> {

    private ListBudgetsFixedSizeCollection(List<ListBudgetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBudgetsFixedSizeCollection createEmptyCollection() {
      return new ListBudgetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBudgetsFixedSizeCollection createCollection(
        List<ListBudgetsPage> pages, int collectionSize) {
      return new ListBudgetsFixedSizeCollection(pages, collectionSize);
    }
  }
}
