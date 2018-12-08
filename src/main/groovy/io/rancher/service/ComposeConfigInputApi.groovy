package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ComposeConfigInput
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ComposeConfigInputApi {

  @POST('v2-beta/composeConfigInputs')
  Call<ComposeConfigInput> create(@Body ComposeConfigInput composeConfigInput)

  @GET('v2-beta/composeConfigInputs/{id}')
  Call<ComposeConfigInput> findById(@Path('id') String id)

}
