package io.rancher.service

import io.rancher.type.AddOutputsInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddOutputsInputApi {

  @GET('v2-beta/addOutputsInputs/{id}')
  Call<AddOutputsInput> findById(@Path('id') String id)
}
