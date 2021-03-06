package io.rancher.service

import io.rancher.type.InstanceConsole
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InstanceConsoleApi {

  @GET('v2-beta/instanceConsoles/{id}')
  Call<InstanceConsole> findById(@Path('id') String id)
}
