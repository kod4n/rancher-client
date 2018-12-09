package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProcessDefinition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProcessDefinitionApi {
  @GET('v2-beta/processDefinitions')
  Call<TypeCollection<ProcessDefinition>> list()

  @GET('v2-beta/processDefinitions')
  Call<TypeCollection<ProcessDefinition>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/processDefinitions/{id}')
  Call<ProcessDefinition> findById(@Path('id') String id)
}
