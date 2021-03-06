package io.rancher.service

import io.rancher.type.ContainerExec
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ContainerExecApi {

  @GET('v2-beta/containerExecs/{id}')
  Call<ContainerExec> findById(@Path('id') String id)
}
