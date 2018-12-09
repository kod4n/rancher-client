package io.rancher.service

import io.rancher.type.BaseMachineConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BaseMachineConfigApi {

  @GET('v2-beta/baseMachineConfigs/{id}')
  Call<BaseMachineConfig> findById(@Path('id') String id)
}
