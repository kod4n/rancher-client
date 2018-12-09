package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.MachineDriver
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MachineDriverApi {
  @GET('v2-beta/machineDrivers')
  Call<TypeCollection<MachineDriver>> list()

  @GET('v2-beta/machineDrivers')
  Call<TypeCollection<MachineDriver>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/machineDrivers')
  Call<MachineDriver> create(@Body MachineDriver machineDriver)

  @GET('v2-beta/machineDrivers/{id}')
  Call<MachineDriver> findById(@Path('id') String id)

  @PUT('v2-beta/machineDrivers/{id}')
  Call<MachineDriver> update(@Path('id') String id, @Body MachineDriver machineDriver)

  @DELETE('v2-beta/machineDrivers/{id}')
  Call<MachineDriver> delete(@Path('id') String id)

  @POST('v2-beta/machineDrivers/{id}?action=reactivate')
  Call<MachineDriver> reactivate(@Path('id') String id)

  @POST('v2-beta/machineDrivers/{id}?action=activate')
  Call<MachineDriver> activate(@Path('id') String id)

  @POST('v2-beta/machineDrivers/{id}?action=error')
  Call<MachineDriver> error(@Path('id') String id)

  @POST('v2-beta/machineDrivers/{id}?action=remove')
  Call<MachineDriver> remove(@Path('id') String id)

  @POST('v2-beta/machineDrivers/{id}?action=deactivate')
  Call<MachineDriver> deactivate(@Path('id') String id)
}
