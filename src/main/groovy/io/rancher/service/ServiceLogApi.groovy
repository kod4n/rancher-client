package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ServiceLog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ServiceLogApi {
  @GET('v2-beta/serviceLogs')
  Call<TypeCollection<ServiceLog>> list()

  @GET('v2-beta/serviceLogs')
  Call<TypeCollection<ServiceLog>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/serviceLogs/{id}')
  Call<ServiceLog> findById(@Path('id') String id)
}
