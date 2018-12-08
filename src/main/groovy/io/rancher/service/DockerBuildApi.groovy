package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.DockerBuild
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface DockerBuildApi {

  @GET('v2-beta/dockerBuilds/{id}')
  Call<DockerBuild> findById(@Path('id') String id)

}
