package io.rancher.service

import io.rancher.type.ServiceUpgradeStrategy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceUpgradeStrategyApi {

  @GET('v2-beta/serviceUpgradeStrategys/{id}')
  Call<ServiceUpgradeStrategy> findById(@Path('id') String id)
}
