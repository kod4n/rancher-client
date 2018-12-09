package io.rancher.service

import io.rancher.type.ContainerProxy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ContainerProxyApi {

  @GET('v2-beta/containerProxys/{id}')
  Call<ContainerProxy> findById(@Path('id') String id)
}
