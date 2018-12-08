package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Backup
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface BackupApi {
  @GET('v2-beta/backups')
  Call<TypeCollection<Backup>> list()

  @GET('v2-beta/backups')
  Call<TypeCollection<Backup>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/backups/{id}')
  Call<Backup> findById(@Path('id') String id)

  @POST('v2-beta/backups/{id}?action=remove')
  Call<Backup> remove(@Path('id') String id)

}
