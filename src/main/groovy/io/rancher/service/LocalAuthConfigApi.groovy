package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.LocalAuthConfig
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface LocalAuthConfigApi {
  @GET('v2-beta/localAuthConfigs')
  Call<TypeCollection<LocalAuthConfig>> list()

  @GET('v2-beta/localAuthConfigs')
  Call<TypeCollection<LocalAuthConfig>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/localAuthConfigs')
  Call<LocalAuthConfig> create(@Body LocalAuthConfig localAuthConfig)

  @GET('v2-beta/localAuthConfigs/{id}')
  Call<LocalAuthConfig> findById(@Path('id') String id)
}
