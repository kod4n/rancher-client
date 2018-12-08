package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExternalHostEvent
import io.rancher.type.ExternalEvent
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExternalHostEventApi {
  @GET('v2-beta/externalHostEvents')
  Call<TypeCollection<ExternalHostEvent>> list()

  @GET('v2-beta/externalHostEvents')
  Call<TypeCollection<ExternalHostEvent>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/externalHostEvents/{id}')
  Call<ExternalHostEvent> findById(@Path('id') String id)

  @POST('v2-beta/externalHostEvents/{id}?action=remove')
  Call<ExternalEvent> remove(@Path('id') String id)

}
