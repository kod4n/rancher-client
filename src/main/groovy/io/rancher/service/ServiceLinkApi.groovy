package io.rancher.service

import io.rancher.type.ServiceLink
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServiceLinkApi {

  @POST('v2-beta/serviceLinks')
  Call<ServiceLink> create(@Body ServiceLink serviceLink)

  @GET('v2-beta/serviceLinks/{id}')
  Call<ServiceLink> findById(@Path('id') String id)
}
