package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.BackupTarget
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface BackupTargetApi {
  @GET('v2-beta/backupTargets')
  Call<TypeCollection<BackupTarget>> list()

  @GET('v2-beta/backupTargets')
  Call<TypeCollection<BackupTarget>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/backupTargets/{id}')
  Call<BackupTarget> findById(@Path('id') String id)

  @POST('v2-beta/backupTargets/{id}?action=remove')
  Call<BackupTarget> remove(@Path('id') String id)

}
