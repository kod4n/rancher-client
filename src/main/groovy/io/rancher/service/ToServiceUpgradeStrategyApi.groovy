package io.rancher.service

import io.rancher.type.ToServiceUpgradeStrategy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ToServiceUpgradeStrategyApi {

  @GET('v2-beta/toServiceUpgradeStrategys/{id}')
  Call<ToServiceUpgradeStrategy> findById(@Path('id') String id)
}
