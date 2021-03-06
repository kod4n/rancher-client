package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.StoragePool
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface StoragePoolApi {
  @GET('v2-beta/storagePools')
  Call<TypeCollection<StoragePool>> list()

  @GET('v2-beta/storagePools')
  Call<TypeCollection<StoragePool>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/storagePools/{id}')
  Call<StoragePool> findById(@Path('id') String id)

  @POST('v2-beta/storagePools/{id}?action=activate')
  Call<StoragePool> activate(@Path('id') String id)

  @POST('v2-beta/storagePools/{id}?action=purge')
  Call<StoragePool> purge(@Path('id') String id)

  @POST('v2-beta/storagePools/{id}?action=remove')
  Call<StoragePool> remove(@Path('id') String id)

  @POST('v2-beta/storagePools/{id}?action=deactivate')
  Call<StoragePool> deactivate(@Path('id') String id)
}
