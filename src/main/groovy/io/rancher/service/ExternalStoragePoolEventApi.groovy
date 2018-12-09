package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ExternalEvent
import io.rancher.type.ExternalStoragePoolEvent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ExternalStoragePoolEventApi {
  @GET('v2-beta/externalStoragePoolEvents')
  Call<TypeCollection<ExternalStoragePoolEvent>> list()

  @GET('v2-beta/externalStoragePoolEvents')
  Call<TypeCollection<ExternalStoragePoolEvent>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/externalStoragePoolEvents/{id}')
  Call<ExternalStoragePoolEvent> findById(@Path('id') String id)

  @POST('v2-beta/externalStoragePoolEvents/{id}?action=remove')
  Call<ExternalEvent> remove(@Path('id') String id)
}
