package io.rancher.service

import io.rancher.type.StackUpgrade
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StackUpgradeApi {

  @GET('v2-beta/stackUpgrades/{id}')
  Call<StackUpgrade> findById(@Path('id') String id)
}
