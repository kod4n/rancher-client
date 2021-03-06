package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Setting
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface SettingApi {
  @GET('v2-beta/settings')
  Call<TypeCollection<Setting>> list()

  @GET('v2-beta/settings')
  Call<TypeCollection<Setting>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/settings')
  Call<Setting> create(@Body Setting setting)

  @GET('v2-beta/settings/{id}')
  Call<Setting> findById(@Path('id') String id)

  @PUT('v2-beta/settings/{id}')
  Call<Setting> update(@Path('id') String id, @Body Setting setting)

  @DELETE('v2-beta/settings/{id}')
  Call<Setting> delete(@Path('id') String id)
}
