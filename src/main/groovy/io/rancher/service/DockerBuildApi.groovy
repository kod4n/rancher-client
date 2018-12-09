package io.rancher.service

import io.rancher.type.DockerBuild
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DockerBuildApi {

  @GET('v2-beta/dockerBuilds/{id}')
  Call<DockerBuild> findById(@Path('id') String id)
}
