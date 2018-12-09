package io.rancher.service

import io.rancher.type.AddRemoveServiceLinkInput
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddRemoveServiceLinkInputApi {

  @GET('v2-beta/addRemoveServiceLinkInputs/{id}')
  Call<AddRemoveServiceLinkInput> findById(@Path('id') String id)
}
