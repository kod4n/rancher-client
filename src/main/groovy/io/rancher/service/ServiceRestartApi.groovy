package io.rancher.service

import io.rancher.type.ServiceRestart
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceRestartApi {

  @GET('v2-beta/serviceRestarts/{id}')
  Call<ServiceRestart> findById(@Path('id') String id)
}
