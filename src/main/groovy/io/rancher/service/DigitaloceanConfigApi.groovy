package io.rancher.service

import io.rancher.type.DigitaloceanConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DigitaloceanConfigApi {

  @POST('v2-beta/digitaloceanConfigs')
  Call<DigitaloceanConfig> create(@Body DigitaloceanConfig digitaloceanConfig)

  @GET('v2-beta/digitaloceanConfigs/{id}')
  Call<DigitaloceanConfig> findById(@Path('id') String id)
}
