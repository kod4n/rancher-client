package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ContainerProxy
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ContainerProxyApi {

  @GET('v2-beta/containerProxys/{id}')
  Call<ContainerProxy> findById(@Path('id') String id)

}
