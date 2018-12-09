package io.rancher.service

import io.rancher.type.Backup
import io.rancher.type.SnapshotBackupInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SnapshotBackupInputApi {

  @GET('v2-beta/snapshotBackupInputs/{id}')
  Call<SnapshotBackupInput> findById(@Path('id') String id)

  @POST('v2-beta/snapshotBackupInputs/{id}?action=remove')
  Call<Backup> remove(@Path('id') String id)
}
