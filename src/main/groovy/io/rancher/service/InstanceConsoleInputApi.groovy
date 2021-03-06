package io.rancher.service

import io.rancher.type.InstanceConsoleInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InstanceConsoleInputApi {

  @GET('v2-beta/instanceConsoleInputs/{id}')
  Call<InstanceConsoleInput> findById(@Path('id') String id)
}
