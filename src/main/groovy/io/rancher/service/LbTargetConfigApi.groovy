package io.rancher.service

import io.rancher.type.LbTargetConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LbTargetConfigApi {

  @GET('v2-beta/lbTargetConfigs/{id}')
  Call<LbTargetConfig> findById(@Path('id') String id)
}
