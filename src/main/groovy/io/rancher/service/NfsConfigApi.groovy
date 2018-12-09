package io.rancher.service

import io.rancher.type.NfsConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NfsConfigApi {

  @GET('v2-beta/nfsConfigs/{id}')
  Call<NfsConfig> findById(@Path('id') String id)
}
