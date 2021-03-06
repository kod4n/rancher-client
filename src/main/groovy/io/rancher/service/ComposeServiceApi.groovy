package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ComposeService
import io.rancher.type.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ComposeServiceApi {
  @GET('v2-beta/composeServices')
  Call<TypeCollection<ComposeService>> list()

  @GET('v2-beta/composeServices')
  Call<TypeCollection<ComposeService>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/composeServices/{id}')
  Call<ComposeService> findById(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=rollback')
  Call<Service> rollback(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=remove')
  Call<Service> remove(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=finishupgrade')
  Call<Service> finishupgrade(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=continueupgrade')
  Call<Service> continueupgrade(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=activate')
  Call<Service> activate(@Path('id') String id)

  @POST('v2-beta/composeServices/{id}?action=cancelupgrade')
  Call<Service> cancelupgrade(@Path('id') String id)
}
