package io.rancher.service

import io.rancher.type.HostAccess
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HostAccessApi {

  @GET('v2-beta/hostAccesses/{id}')
  Call<HostAccess> findById(@Path('id') String id)
}
