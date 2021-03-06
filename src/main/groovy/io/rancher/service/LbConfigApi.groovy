package io.rancher.service

import io.rancher.type.LbConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LbConfigApi {

  @GET('v2-beta/lbConfigs/{id}')
  Call<LbConfig> findById(@Path('id') String id)
}
