package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Container
import io.rancher.type.ContainerExec
import io.rancher.type.ContainerLogs
import io.rancher.type.ContainerProxy
import io.rancher.type.HostAccess
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

interface ContainerApi {
  @GET('v2-beta/containers')
  Call<TypeCollection<Container>> list()

  @GET('v2-beta/containers')
  Call<TypeCollection<Container>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/containers/{id}')
  Call<Container> findById(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthy(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=console')
  Call<InstanceConsole> console(@Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/containers/{id}?action=restart')
  Call<Instance> restart(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=deallocate')
  Call<Instance> deallocate(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=start')
  Call<Instance> start(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializing(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=purge')
  Call<Instance> purge(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=error')
  Call<Instance> error(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=remove')
  Call<Instance> remove(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=stop')
  Call<Instance> stop(@Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/containers/{id}?action=allocate')
  Call<Instance> allocate(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=updatehealthy')
  Call<Instance> updatehealthy(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=migrate')
  Call<Instance> migrate(@Path('id') String id)

  @POST('v2-beta/containers/{id}?action=logs')
  Call<HostAccess> logs(@Path('id') String id, @Body ContainerLogs containerLogs)

  @POST('v2-beta/containers/{id}?action=execute')
  Call<HostAccess> execute(@Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/containers/{id}?action=proxy')
  Call<HostAccess> proxy(@Path('id') String id, @Body ContainerProxy containerProxy)
}
