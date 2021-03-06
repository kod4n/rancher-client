package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExternalService
import io.rancher.type.Service
import io.rancher.type.ServiceRestart
import io.rancher.type.ServiceUpgrade
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExternalServiceApi {
  @GET('v2-beta/externalServices')
  Call<TypeCollection<ExternalService>> list()

  @GET('v2-beta/externalServices')
  Call<TypeCollection<ExternalService>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/externalServices/{id}')
  Call<ExternalService> findById(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=rollback')
  Call<Service> rollback(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=upgrade')
  Call<Service> upgrade(@Path('id') String id, @Body ServiceUpgrade serviceUpgrade)

  @POST('v2-beta/externalServices/{id}?action=restart')
  Call<Service> restart(@Path('id') String id, @Body ServiceRestart serviceRestart)

  @POST('v2-beta/externalServices/{id}?action=remove')
  Call<Service> remove(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=deactivate')
  Call<Service> deactivate(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=finishupgrade')
  Call<Service> finishupgrade(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=continueupgrade')
  Call<Service> continueupgrade(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=activate')
  Call<Service> activate(@Path('id') String id)

  @POST('v2-beta/externalServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgrade(@Path('id') String id)
}
