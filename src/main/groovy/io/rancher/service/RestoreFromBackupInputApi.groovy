package io.rancher.service

import io.rancher.type.RestoreFromBackupInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestoreFromBackupInputApi {

  @GET('v2-beta/restoreFromBackupInputs/{id}')
  Call<RestoreFromBackupInput> findById(@Path('id') String id)
}
