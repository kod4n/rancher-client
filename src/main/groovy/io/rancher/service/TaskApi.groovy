package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Task
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface TaskApi {
  @GET('v2-beta/tasks')
  Call<TypeCollection<Task>> list()

  @GET('v2-beta/tasks')
  Call<TypeCollection<Task>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/tasks/{id}')
  Call<Task> findById(@Path('id') String id)

  @POST('v2-beta/tasks/{id}?action=execute')
  Call<Task> execute(@Path('id') String id)
}
