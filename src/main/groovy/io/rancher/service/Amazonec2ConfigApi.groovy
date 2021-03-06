package io.rancher.service

import io.rancher.type.Amazonec2Config
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Amazonec2ConfigApi {

  @POST('v2-beta/amazonec2Configs')
  Call<Amazonec2Config> create(@Body Amazonec2Config amazonec2Config)

  @GET('v2-beta/amazonec2Configs/{id}')
  Call<Amazonec2Config> findById(@Path('id') String id)
}
