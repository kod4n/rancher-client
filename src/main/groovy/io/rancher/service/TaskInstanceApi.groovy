package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.TaskInstance
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TaskInstanceApi {
  @GET('v2-beta/taskInstances')
  Call<TypeCollection<TaskInstance>> list()

  @GET('v2-beta/taskInstances')
  Call<TypeCollection<TaskInstance>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/taskInstances/{id}')
  Call<TaskInstance> findById(@Path('id') String id)
}
