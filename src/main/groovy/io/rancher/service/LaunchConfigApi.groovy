package io.rancher.service

import io.rancher.type.ContainerExec
import io.rancher.type.ContainerProxy
import io.rancher.type.HostAccess
import io.rancher.type.Instance
import io.rancher.type.InstanceConsole
import io.rancher.type.InstanceConsoleInput
import io.rancher.type.InstanceStop
import io.rancher.type.LaunchConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface LaunchConfigApi {

  @POST('v2-beta/launchConfigs')
  Call<LaunchConfig> create(@Body LaunchConfig launchConfig)

  @GET('v2-beta/launchConfigs/{id}')
  Call<LaunchConfig> findById(@Path('id') String id)

  @PUT('v2-beta/launchConfigs/{id}')
  Call<LaunchConfig> update(@Path('id') String id, @Body LaunchConfig launchConfig)

  @POST('v2-beta/launchConfigs/{id}?action=updateunhealthy')
  Call<Instance> updateunhealthy(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=console')
  Call<InstanceConsole> console(@Path('id') String id, @Body InstanceConsoleInput instanceConsoleInput)

  @POST('v2-beta/launchConfigs/{id}?action=restart')
  Call<Instance> restart(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=deallocate')
  Call<Instance> deallocate(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=start')
  Call<Instance> start(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=updatereinitializing')
  Call<Instance> updatereinitializing(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=purge')
  Call<Instance> purge(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=error')
  Call<Instance> error(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=remove')
  Call<Instance> remove(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=stop')
  Call<Instance> stop(@Path('id') String id, @Body InstanceStop instanceStop)

  @POST('v2-beta/launchConfigs/{id}?action=allocate')
  Call<Instance> allocate(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=updatehealthy')
  Call<Instance> updatehealthy(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=migrate')
  Call<Instance> migrate(@Path('id') String id)

  @POST('v2-beta/launchConfigs/{id}?action=execute')
  Call<HostAccess> execute(@Path('id') String id, @Body ContainerExec containerExec)

  @POST('v2-beta/launchConfigs/{id}?action=proxy')
  Call<HostAccess> proxy(@Path('id') String id, @Body ContainerProxy containerProxy)
}
