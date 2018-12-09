package io.rancher.service

import io.rancher.type.ExternalHandlerProcessConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ExternalHandlerProcessConfigApi {

  @POST('v2-beta/externalHandlerProcessConfigs')
  Call<ExternalHandlerProcessConfig> create(@Body ExternalHandlerProcessConfig externalHandlerProcessConfig)

  @GET('v2-beta/externalHandlerProcessConfigs/{id}')
  Call<ExternalHandlerProcessConfig> findById(@Path('id') String id)
}
