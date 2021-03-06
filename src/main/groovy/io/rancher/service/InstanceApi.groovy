package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Instance
import io.rancher.type.InstanceConsole
import io.rancher.type.InstanceConsoleInput
import io.rancher.type.InstanceStop
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface InstanceApi {
  @GET('v2-beta/instances')
  Call<TypeCollection<Instance>> list()

  @GET('v2-beta/instances')
  Call<TypeCollection<Instance>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/instances/{id}')
  Call<Instance> findById(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthy(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=console')
  Call<InstanceConsole> console(@Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/instances/{id}?action=restart')
  Call<Instance> restart(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=deallocate')
  Call<Instance> deallocate(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=start')
  Call<Instance> start(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializing(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=purge')
  Call<Instance> purge(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=error')
  Call<Instance> error(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=remove')
  Call<Instance> remove(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=stop')
  Call<Instance> stop(@Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/instances/{id}?action=allocate')
  Call<Instance> allocate(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=updatehealthy')
  Call<Instance> updatehealthy(@Path('id') String id)

  @POST('v2-beta/instances/{id}?action=migrate')
  Call<Instance> migrate(@Path('id') String id)
}
