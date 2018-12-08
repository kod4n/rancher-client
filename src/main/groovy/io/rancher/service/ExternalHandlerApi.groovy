package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExternalHandler
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExternalHandlerApi {
  @GET('v2-beta/externalHandlers')
  Call<TypeCollection<ExternalHandler>> list()

  @GET('v2-beta/externalHandlers')
  Call<TypeCollection<ExternalHandler>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/externalHandlers')
  Call<ExternalHandler> create(@Body ExternalHandler externalHandler)

  @GET('v2-beta/externalHandlers/{id}')
  Call<ExternalHandler> findById(@Path('id') String id)

  @PUT('v2-beta/externalHandlers/{id}')
  Call<ExternalHandler> update(@Path('id') String id, @Body ExternalHandler externalHandler)

  @POST('v2-beta/externalHandlers/{id}?action=activate')
  Call<ExternalHandler> activate(@Path('id') String id)

  @POST('v2-beta/externalHandlers/{id}?action=purge')
  Call<ExternalHandler> purge(@Path('id') String id)

  @POST('v2-beta/externalHandlers/{id}?action=remove')
  Call<ExternalHandler> remove(@Path('id') String id)

  @POST('v2-beta/externalHandlers/{id}?action=deactivate')
  Call<ExternalHandler> deactivate(@Path('id') String id)

}
