package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.PhysicalHost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PhysicalHostApi {
  @GET('v2-beta/physicalHosts')
  Call<TypeCollection<PhysicalHost>> list()

  @GET('v2-beta/physicalHosts')
  Call<TypeCollection<PhysicalHost>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/physicalHosts/{id}')
  Call<PhysicalHost> findById(@Path('id') String id)

  @POST('v2-beta/physicalHosts/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrap(@Path('id') String id)

  @POST('v2-beta/physicalHosts/{id}?action=error')
  Call<PhysicalHost> error(@Path('id') String id)

  @POST('v2-beta/physicalHosts/{id}?action=remove')
  Call<PhysicalHost> remove(@Path('id') String id)
}
