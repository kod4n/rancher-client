package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ServiceProxy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ServiceProxyApi {
  @GET('v2-beta/serviceProxies')
  Call<TypeCollection<ServiceProxy>> list()

  @GET('v2-beta/serviceProxies')
  Call<TypeCollection<ServiceProxy>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/serviceProxies/{id}')
  Call<ServiceProxy> findById(@Path('id') String id)
}
