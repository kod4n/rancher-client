package io.rancher.service

import io.rancher.type.ContainerLogs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ContainerLogsApi {

  @GET('v2-beta/containerLogses/{id}')
  Call<ContainerLogs> findById(@Path('id') String id)
}
