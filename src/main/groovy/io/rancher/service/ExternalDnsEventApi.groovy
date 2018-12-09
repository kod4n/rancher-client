package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExternalDnsEvent
import io.rancher.type.ExternalEvent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExternalDnsEventApi {
  @GET('v2-beta/externalDnsEvents')
  Call<TypeCollection<ExternalDnsEvent>> list()

  @GET('v2-beta/externalDnsEvents')
  Call<TypeCollection<ExternalDnsEvent>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/externalDnsEvents/{id}')
  Call<ExternalDnsEvent> findById(@Path('id') String id)

  @POST('v2-beta/externalDnsEvents/{id}?action=remove')
  Call<ExternalEvent> remove(@Path('id') String id)
}
