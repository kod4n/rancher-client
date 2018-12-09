package io.rancher.service

import io.rancher.type.PublicEndpoint
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PublicEndpointApi {

  @POST('v2-beta/publicEndpoints')
  Call<PublicEndpoint> create(@Body PublicEndpoint publicEndpoint)

  @GET('v2-beta/publicEndpoints/{id}')
  Call<PublicEndpoint> findById(@Path('id') String id)
}
