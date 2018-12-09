package io.rancher.service

import io.rancher.type.SetServiceLinksInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SetServiceLinksInputApi {

  @GET('v2-beta/setServiceLinksInputs/{id}')
  Call<SetServiceLinksInput> findById(@Path('id') String id)
}
