package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ProcessInstance
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ProcessInstanceApi {
  @GET('v2-beta/processInstances')
  Call<TypeCollection<ProcessInstance>> list()

  @GET('v2-beta/processInstances')
  Call<TypeCollection<ProcessInstance>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/processInstances/{id}')
  Call<ProcessInstance> findById(@Path('id') String id)

  @POST('v2-beta/processInstances/{id}?action=replay')
  Call<ProcessInstance> replay(@Path('id') String id)
}
