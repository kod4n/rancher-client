package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProcessExecution
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProcessExecutionApi {
  @GET('v2-beta/processExecutions')
  Call<TypeCollection<ProcessExecution>> list()

  @GET('v2-beta/processExecutions')
  Call<TypeCollection<ProcessExecution>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/processExecutions/{id}')
  Call<ProcessExecution> findById(@Path('id') String id)
}
