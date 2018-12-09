package io.rancher.service

import io.rancher.type.ActiveSetting
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ActiveSettingApi {

  @GET('v2-beta/activeSettings/{id}')
  Call<ActiveSetting> findById(@Path('id') String id)

  @PUT('v2-beta/activeSettings/{id}')
  Call<ActiveSetting> update(@Path('id') String id, @Body ActiveSetting activeSetting)

  @DELETE('v2-beta/activeSettings/{id}')
  Call<ActiveSetting> delete(@Path('id') String id)
}
