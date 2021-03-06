package io.rancher.service

import io.rancher.type.Publish
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PublishApi {

  @POST('v2-beta/publish')
  Call<Publish> create(@Body Publish publish)

  @GET('v2-beta/publish/{id}')
  Call<Publish> findById(@Path('id') String id)
}
