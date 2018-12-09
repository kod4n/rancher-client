package io.rancher.service

import io.rancher.type.StatsAccess
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StatsAccessApi {

  @GET('v2-beta/statsAccesses/{id}')
  Call<StatsAccess> findById(@Path('id') String id)
}
