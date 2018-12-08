package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Snapshot
import io.rancher.type.SnapshotBackupInput
import io.rancher.type.Backup
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface SnapshotApi {
  @GET('v2-beta/snapshots')
  Call<TypeCollection<Snapshot>> list()

  @GET('v2-beta/snapshots')
  Call<TypeCollection<Snapshot>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/snapshots/{id}')
  Call<Snapshot> findById(@Path('id') String id)

  @POST('v2-beta/snapshots/{id}?action=backup')
  Call<Backup> backup(@Path('id') String id, @Body SnapshotBackupInput snapshotBackupInput)
  @POST('v2-beta/snapshots/{id}?action=remove')
  Call<Snapshot> remove(@Path('id') String id)

}
