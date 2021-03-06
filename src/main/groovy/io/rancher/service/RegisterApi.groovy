package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.GenericObject
import io.rancher.type.Instance
import io.rancher.type.InstanceStop
import io.rancher.type.Register
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RegisterApi {
  @GET('v2-beta/register')
  Call<TypeCollection<Register>> list()

  @GET('v2-beta/register')
  Call<TypeCollection<Register>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/register/{id}')
  Call<Register> findById(@Path('id') String id)

  @POST('v2-beta/register/{id}?action=remove')
  Call<GenericObject> remove(@Path('id') String id)

  @POST('v2-beta/register/{id}?action=stop')
  Call<Instance> stop(@Path('id') String id, @Body InstanceStop instanceStop)
}
