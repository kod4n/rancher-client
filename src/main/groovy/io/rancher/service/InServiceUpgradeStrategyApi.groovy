package io.rancher.service

import io.rancher.type.InServiceUpgradeStrategy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InServiceUpgradeStrategyApi {

  @GET('v2-beta/inServiceUpgradeStrategys/{id}')
  Call<InServiceUpgradeStrategy> findById(@Path('id') String id)
}
