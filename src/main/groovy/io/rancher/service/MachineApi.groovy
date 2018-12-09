package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Machine
import io.rancher.type.PhysicalHost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MachineApi {
  @GET('v2-beta/machines')
  Call<TypeCollection<Machine>> list()

  @GET('v2-beta/machines')
  Call<TypeCollection<Machine>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/machines/{id}')
  Call<Machine> findById(@Path('id') String id)

  @POST('v2-beta/machines/{id}?action=bootstrap')
  Call<PhysicalHost> bootstrap(@Path('id') String id)

  @POST('v2-beta/machines/{id}?action=error')
  Call<PhysicalHost> error(@Path('id') String id)

  @POST('v2-beta/machines/{id}?action=remove')
  Call<PhysicalHost> remove(@Path('id') String id)
}
