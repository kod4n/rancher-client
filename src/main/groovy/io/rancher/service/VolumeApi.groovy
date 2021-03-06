package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.RestoreFromBackupInput
import io.rancher.type.RevertToSnapshotInput
import io.rancher.type.Snapshot
import io.rancher.type.Volume
import io.rancher.type.VolumeSnapshotInput
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface VolumeApi {
  @GET('v2-beta/volumes')
  Call<TypeCollection<Volume>> list()

  @GET('v2-beta/volumes')
  Call<TypeCollection<Volume>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/volumes/{id}')
  Call<Volume> findById(@Path('id') String id)

  @POST('v2-beta/volumes/{id}?action=allocate')
  Call<Volume> allocate(@Path('id') String id)

  @POST('v2-beta/volumes/{id}?action=restorefrombackup')
  Call<Volume> restorefrombackup(@Path('id') String id, @Body RestoreFromBackupInput restoreFromBackupInput)

  @POST('v2-beta/volumes/{id}?action=deallocate')
  Call<Volume> deallocate(@Path('id') String id)

  @POST('v2-beta/volumes/{id}?action=purge')
  Call<Volume> purge(@Path('id') String id)

  @POST('v2-beta/volumes/{id}?action=remove')
  Call<Volume> remove(@Path('id') String id)

  @POST('v2-beta/volumes/{id}?action=reverttosnapshot')
  Call<Volume> reverttosnapshot(@Path('id') String id, @Body RevertToSnapshotInput revertToSnapshotInput)

  @POST('v2-beta/volumes/{id}?action=snapshot')
  Call<Snapshot> snapshot(@Path('id') String id, @Body VolumeSnapshotInput volumeSnapshotInput)
}
