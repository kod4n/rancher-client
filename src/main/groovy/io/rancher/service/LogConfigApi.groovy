package io.rancher.service

import io.rancher.type.LogConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LogConfigApi {

  @GET('v2-beta/logConfigs/{id}')
  Call<LogConfig> findById(@Path('id') String id)
}
